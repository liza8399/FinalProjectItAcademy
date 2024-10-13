# FinalProject for ItAcademy
Author - Fralova Lizaveta. 
Project for lamoda.by - one of the largest online stores in the CIS

## Technologies
Project is created with:
* java version: 21
* selenium version: 4.23.0
* rest-assured version: 5.5.0
* allure version: 2.24.0
* aspectj version: 1.9.20.1
* testng version: 7.10.2

## Pages:
* CartPage - selectors, constructors and methods on the Cart page. 
* HomePage - selectors, constructors and methods on the Home page. 
* ItemPage - selectors, constructors and methods on the Item page. 
* LoginPage - selectors, constructors and methods on the Login page. 
* SearchPage - selectors, constructors and methods on the Search page. 

## Listeners:
* TestListeners - created listeners with LOGGERs.
* SeleniumListener - created listeners for actions.

## Utils:
* ConfigurationReader - loading the browser value from the file configuration.properties but also overriding the value from the file.
* DriverFactory - creating WebDriver.
* DriverManager - responsible for managing the WebDriver object and ensuring its creation and proper termination in a multi-threaded environment.
* JSExecutorUtils - utils for work with elements, that could be non-interactive. 
* ScreenshotUtils - for screenshots.
* Waiters 

## Resources:
* allure.properties - to specify settings for the Allure report
* configuration.properties 
* log4j2.properties - to specify settings for log4j2

## Apitests:
APILamodaTest - created for API tests

## Uitests:
* BaseTest - created for Before- and AfterMethod for UI tests
* LoginTest - created for login test
* CartTest - created for setUp cart test
* SearchTest - created for search tests

## Resources:
### json:
login.json

### suites:
* alltest - suite for all UI tests.
* apitestsuite - suite for all API tests.
* carttest - suite for cart tests.
* logintet - suite for login tests.
* searchtest - suite for search tests.

