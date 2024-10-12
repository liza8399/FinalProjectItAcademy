# FinalProject for ItAcademy
Author - Fralova Lizaveta
Project for lamoda.by - one of the largest online stores in the CIS

## Technologies
Project is created with:
* java version: 21
* selenium version: 4.23.0
* rest-assured version: 5.5.0
* allure version: 2.24.0
* aspectj version: 1.9.20.1
* testng version: 7.10.2

# Pages:
## CartPage - selectors, constructors and methods on the Cart page 
## HomePage - selectors, constructors and methods on the Home page 
## ItemPage - selectors, constructors and methods on the Item page 
## LoginPage - selectors, constructors and methods on the Login page 
## SearchPage - selectors, constructors and methods on the Search page 

# Listeners:
## TestListeners - created listeners with LOGGERs
## ElementActionListener - created listeners for actions

# Utils:
## ConfigurationReader
## DriverFactory
## DriverManager
## JSExecutorUtils
## ScreenshotUtils - for screenshots
## Waiters

# Resources:
## allure properties - to specify settings for the Allure report
## configuration.properties 
## log4j2.properties - to specify settings for log4j2

# Apitests:
## APILamodaTest - created for API tests

# Uitests:
## BaseTest - created for Before- and AfterMethod for UI tests
## LoginTest - created for login test
## CartTest - created for setUp cart test
## SearchTest - created for search tests

# Resources:
## json
### login.json

## suites:
### alltest
### apitestsuite
### carttest
### logintet
### searchtest

