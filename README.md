# datomic-setup

Setting up the datomic partitions and scheme by running a (docker-)script.

## Installation

-

## Usage

    $ docker run simplexsys/stuffiedo-datomic-init --uri "datomic:free://localhost:4334/mydb"
or

    $ docker run simplexsys/stuffiedo-datomic-init -u "datomic:free://localhost:4334/mydb"
    
Both commands run an init script, adding partitions and schema's to the datomic database given in --uri or -u. 

## Options

--uri or -u

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2015 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
