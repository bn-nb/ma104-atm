@echo off

cls
cd .\atm_proj
del *.class
javac -Xlint *.java
cd ..
java atm_proj.RunFile
