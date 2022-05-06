# db-exporter

A tool which is able to create simple SQL scripts which contains INSERT statements to restore a database content in the 
right order respecting data integrity rules.

## Requirement

* Java 11+
* Maven 3.5.4+
* Archimedes 2.0.1+ (checked out and build locally - Take note of Archimedes readme file)


## Build

Build the project with 

```
mvn clean install
```

via a console.

**Note:** Build will only be possible if you have build the archimedes-legacy project on your local machine before 
("archimedes-legacy" could by cloned on https://github.com/greifentor/archimedes-legacy; read the note of this project 
to build Archimedes).


## Start

After building the project start with:

**TODO**


## Parameters

### file

A the parameter ``--file=[filename]`` to the program call to define which file should be use. This file must be an
Archimedes Data Model in XML format.


## Table Model Option

### DB_EXPORTER_IGNORE

Mark table which should not be exported with option ``DB_EXPORTER_IGNORE`` in the Archimedes Data Model.