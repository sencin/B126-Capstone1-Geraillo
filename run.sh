#!/bin/bash
echo "Compiling Console Program..."
javac -d target/classes -sourcepath src/main/java src/main/java/org/b126/Main.java

if [ $? -eq 0 ]; then
    echo "Compilation successful! Running program..."
    echo "-----------------------------------------"
     java -cp target/classes org.b126.Main
else
    echo "Compilation failed. Please check errors above."
fi
