#!/bin/bash

python src/filter.py data/tcr.gbk
./mixcr align generated/filtered.fasta generated/alignments.vdjca
./mixcr exportAlignments generated/alignments.vdjca generated/alignments.txt
./mixcr exportAlignments -readid -nFeature CDR3 generated/alignments.vdjca generated/cdr3.txt
python src/list.py

javac -sourcepath ./src -d bin src/main/Main.java
java -classpath ./bin main.Main
