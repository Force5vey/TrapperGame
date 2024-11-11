@echo off
echo Compiling Java files...

javac -d bin TrapperGame.java models/*.java controllers/*.java utils/*.java

if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)

echo Compilation successful.
pause
