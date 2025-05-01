
Guru99 Banking Automation Project

Project Overview

This project automates the testing of the Guru99 Bank web application using Selenium WebDriver, TestNG, and Allure Reports. It includes:

Selenium WebDriver with Java

TestNG framework with data-driven testing

Allure Reports for detailed test reporting

Custom browser management system

Screenshot capture on test failures

Key Features
✔ Page Object Model implementation
✔ Data-Driven Testing using Excel & TestNG @DataProvider
✔ Custom Browser Actions for flexible browser selection
✔ Automatic Screenshots 
✔ Allure Reporting with test execution details
📦 Guru99Banking
├── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   ├── 📂 actions
│   │   │   │   ├── BrowserActions.java
│   │   │   │   └── ElementActions.java
│   │   │   └── 📂 pom
│   │   │       ├── HomePage.java
│   │   │       └── LoginPage.java
│   │   └── 📂 resources
│   │       └── LoginTestData.xlsx
│   │
│   └── 📂 test
│       ├── 📂 java
│       │   ├── BaseTests.java
│       │   ├── ExcelReader.java
│       │   ├── TC_01_VerifyLoginSection.java
│       │   ├── TC_02_VerifyLoginSectionUsingDataProvider.java
│       │   └── Util.java
│       └── 📂 resources
│           └── allure.properties
│           
│
├── 📂 target
│   ├── 📂 allure-results
│   ├── 📂 classes
│   ├── 📂 generated-sources
│   ├── 📂 generated-test-sources
│   ├── 📂 screenshots
│   └── 📂 test-classes
│
├── 📄 pom.xml
└── 📄 testng.xml

How to Run the Project
1. Prerequisites
Java 11+

Maven

Chrome browser (default)

2. Execution Commands
bash
# Run tests
mvn clean test

# Generate Allure report
allure serve target/allure-results
3. Viewing Results
Allure report: target/allure-results

Screenshots: target/screenshots

Key Achievements:
✓ Improved test maintainability with POM design
✓ Enhanced debugging with automatic screenshots


