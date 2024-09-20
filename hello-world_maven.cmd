REM Windows

REM build
cmd /c mvn clean install 
@REM the install commands aborts the cmd process so we need to run using /c

REM run
mvn exec:java@helloworld 