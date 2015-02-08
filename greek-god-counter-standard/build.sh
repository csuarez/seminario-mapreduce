#!/bin/sh
echo ">> Cleaning files..."
rm -f *.class
rm -f *.jar
export CLASSPATH=/etc/hadoop/conf:/usr/lib/hadoop/lib/*:/usr/lib/hadoop/.//*:/usr/lib/hadoop-hdfs/./:/usr/lib/hadoop-hdfs/lib/*:/usr/lib/hadoop-hdfs/.//*:/usr/lib/hadoop-yarn/lib/*:/usr/lib/hadoop-yarn/.//*:/usr/lib/hadoop-mapreduce/lib/*:/usr/lib/hadoop-mapreduce/.//*:./lib/opencsv-2.3.jar:./build/*
echo ">> Compiling..."
javac -classpath $CLASSPATH *.java
echo Main-Class: GreekGodCounterStandard > manifest.txt
jar cvfm GreekGodCounterStandard.jar manifest.txt  *.class
rm -rf manifest.txt
echo ">> Done!"
