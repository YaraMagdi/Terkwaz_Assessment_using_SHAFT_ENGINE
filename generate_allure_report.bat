@echo off
set path=C:\Users\yara\.m2\repository\allure\allure-2.13.0\bin;%path%
allure serve allure-results
pause
exit