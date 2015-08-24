#!/bin/bash

#Creating filtered lists with alpha/beta chains in convenient format
./process.sh

#Pushing information from lists above to reference classes (AlphaChain/BetaChain) removes those which dont have V(D)J regions and CDR3 and then prints to alpha_test.txt and beta_test.txt in "generated" folder
javac -sourcepath ./src -d bin src/main/Main.java
java -classpath ./bin main.Main
