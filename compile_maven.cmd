REM Windows

REM build
start mvn clean install 
@REM the install commands aborts the cmd process so we need to run in a different process

timeout 5

REM run
mvn exec:java@helloworld 