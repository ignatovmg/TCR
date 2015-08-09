#!/bin/bash

# Creating filtered lists with alpha/beta chains in convenient format
python src/beta_filter.py data/tcr.gbk
./mixcr align generated/beta_filtered.fasta generated/beta_alignments.vdjca
./mixcr exportAlignments generated/beta_alignments.vdjca generated/beta_alignments.txt
./mixcr exportAlignments -readid -nFeature CDR3 generated/beta_alignments.vdjca generated/beta_cdr3.txt
python src/beta_list.py

python src/alpha_filter.py data/tcr.gbk
./mixcr align generated/alpha_filtered.fasta generated/alpha_alignments.vdjca
./mixcr exportAlignments generated/alpha_alignments.vdjca generated/alpha_alignments.txt
./mixcr exportAlignments -readid -nFeature CDR3 generated/alpha_alignments.vdjca generated/alpha_cdr3.txt
python src/alpha_list.py

#Pushing information from lists above to reference classes (AlphaChain/BetaChain) removes those which dont have V(D)J regions and CDR3 and then prints to alpha_test.txt and beta_test.txt in "generated" folder
javac -sourcepath ./src -d bin src/main/Main.java
java -classpath ./bin main.Main
