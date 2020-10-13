# Mutable Value for Kotlin
![Language](https://img.shields.io/github/languages/top/ZoftWhere/mutable-value-kt)
[![License](https://img.shields.io/github/license/ZoftWhere/mutable-value-kt)](https://github.com/ZoftWhere/mutable-value-kt/blob/master/license.txt)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/ZoftWhere/mutable-value-kt)
![GitHub Release Date](https://img.shields.io/github/release-date/ZoftWhere/mutable-value-kt)
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/ZoftWhere/mutable-value-kt/master?label=master%20updated)

A mutable value for Kotlin (include functional interface).

## Overview

This is an example project of how to structure Kotlin source code in a manner such that the produced library can be used; even with functional semantics that are only available in later Java APIs.

The Mutable Value for Kotlin also provides a solution for creating instances that need to be effectively final, functional, and allow for their state to change.  The MutableValue class should be used, although sparingly, as a tool for producing code that limits the risks of mutability to context, whilst at the same time source code that is idiomatic of functional coding styles.

Again, this is just an example project.

## Compiling and Installing

The project has a Maven project file with which the project can be built using Maven.  It has been tested with Apache Maven v3.6.3.  To run the project test source code requires at least JDK11.

### Installing with JDK 11

The project can be installed to the local repository with JDK11 or JDK14:  

``` shell script
mvn clean install 
```

### Installing with JDK 8

The project can be installed to the local repository with JDK8:  

``` shell script
mvn clean kotlin:compile@main-compile-kt jar:jar@main-jar source:jar@main-sources moditect:add-module-info@main-jpms install:install-file@main-install
```

## License

Copyright (c) 2020 ZoftWhere

Licensed under the MIT License

------