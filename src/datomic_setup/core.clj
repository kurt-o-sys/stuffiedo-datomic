(ns datomic-setup.core
  (:require [datomic.api :as d]
            [clojure.tools.cli :refer [parse-opts]]
            )
  (:gen-class))

(defn -main
  "Setup datomic schema"
  [& args]
  (let [opts (:options (parse-opts args 
                                   [["-u" "--uri URI" "db uri" 
                                     :default "datomic:free://localhost:4334/mydb"]]) ) 
        uri (:uri opts)]
    (prn (str "set up database '" uri "'"))
    (d/create-database (:uri opts))
    (let [conn (d/connect uri)]
      (prn "start partitions:")
      @(d/transact conn (read-string (slurp "./resources/partitions.edn")))
      (prn "done...")
      (prn "start importing schema:")
      @(d/transact conn (read-string (slurp "./resources/schema.edn")))
      (prn "done")
      (d/shutdown true))
    ) )
