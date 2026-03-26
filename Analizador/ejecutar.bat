@echo off
cd /d "%~dp0"
mkdir bin 2>nul
javac -d bin src\*.java
java -cp bin Main
pause