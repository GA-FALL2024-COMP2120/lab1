mkdir -p ./target/classes
#compiles the code
javac -d "./target/classes" "./src/main/java/lab1/HelloWorld.java"
#runs the code
java -cp "./target/classes" lab1.HelloWorld