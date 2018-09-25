#!/bin/bash
# Pack up the source distribution

DistDir=target/distribution
JarFile=tescoban-tale-solution-peterp-src.zip
mkdir -p ${DistDir}
jar cvf ${DistDir}/${JarFile}  .gitignore *.sh *.txt *.md *.sbt  src
# End.
