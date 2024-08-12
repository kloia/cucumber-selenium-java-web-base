# Java Selenium With TestNG Cucumber Test Automation Project

This project is a base project for Java-Selenium-Cucumber Test Automation Projects.

It includes processes such as parallel execution and rerunning failed test cases. Allure Report is used for reporting.
# Tool stack

* **Java/Javascript** - Development Language
* **IntelliJ IDE** - Development IDE
* **Maven** - Package Management
* **Cucumber** - Gherkin Syntax Framework
* **Selenium** - Web APP Test Automation Tool
* **TestNG** - Web App Test Automation Tool and Testing Framework

# Documentation
* Initiate a Selenium-Java Setup <a href="https://www.selenium.dev/documentation/">documentation</a>
* Browser <a href="https://www.selenium.dev/documentation/webdriver/browsers/">documentation</a>
* Element <a href="https://www.selenium.dev/documentation/webdriver/elements/">documentation</a>

# Installations

* To install the necessary libraries , the following command is run in the project directory.
  ```
  mvn clean install
  ```

# Run Test

```
mvn clean test
```

### Maven Run With Runner Name And Parameter

```
mvn clean test -Dtest=Runner -D"cucumber.filter.tags=@regression" -Dheadless=true -DthreadCount=5
```

### Maven Run With Parameter

```
mvn clean test -D"cucumber.filter.tags=@register" -Dheadless=true -DthreadCount=5
```

### Cucumber Tag Run

Example for `@register` tag:
```
mvn clean test -D"cucumber.filter.tags=@register"
```

# Reporting
```
allure serve allure-results 
```


# Project Folder Structure

```
.
|-- src
|   |-- test
|   |   |-- java
|   |   |   |   |-- config
|   |   |   |   |   |-- BaseConfig
|   |   |   |   |-- pages
|   |   |   |   |   |-- BasePage
|   |   |   |   |   |-- HomePage
|   |   |   |   |   |-- SignUpPage
|   |   |   |   |-- runners
|   |   |   |   |   |-- Runner
|   |   |   |   |-- stepDefinitions
|   |   |   |   |   |-- BaseSteps
|   |   |   |   |   |-- HomeSteps
|   |   |   |   |   |-- Hooks
|   |   |   |   |   |-- SignUpSteps
|   |   |   |   |-- utilities
|   |   |   |   |   |-- DataGenerator
|   |   |   |   |   |-- LogUtil
|   |   |   |   |   |-- PageHelper
|   |   |   |   |   |-- ResourceFileReader
|   |   |-- resources
|   |   |   |-- features
|   |   |   |   |-- register.feature
|-- git.ignore
|-- pom.xml
|-- testng.xml
|-- README.md
```

# Naming Convention

We use `camelCase` for identifier names (variables and functions).

Use `PascalCase` only when naming constructors or classes

All names start with a letter.

At the bottom of this page, you will find a wider discussion about naming rules

```
folder name = my_folder

js file name = my_file.js

feature file name = my_feature.rb

class name = MyClass

function name = myMethod

variable name = myVariable

element name = btnMyElement, lblMyElement, txtMyElement

Enum = ALL_CAPITAL = 'value'

Constant = MY_CONSTANT

tag name = @my_tag 

```

# Web Element Standards

| Prefix        | Example     | Locator      |
| ------------- |-------------|------------- |
| btn           | btnLogin    |  Button      |
| chk           | chkStatus   |  Checkbox    |
| cbx           | cbxEnglish  |  Combo box   |
| lbl           | lblUsername |  Label       |
| drp           | drpList     |  Drop down   |
| slc           | slcList     |  Selectbox   |
| txt           | txtEmail    |  Textbox     |
| img           | imgLogo     |  Image       |
| rdx           | rdxFemale   |  Radiobox    |

# Page Method Standards

| Prefix | Action        | Description                |
|--------|---------------|----------------------------|
| click  | clickRegister | Click button or link       |
| fill   | fillEmail     | Type textbox               |
| check  | checkGender   | Check a check box          |
| select | selectYear    | Select value from drop down |
| verify | verifyMenu    | Assertion                  |

# Scenario Standards

* Scenarios will be written in `feature` file.
* The syntax ``Given, When, Then, And`` will be used.
* At the beginning of the feature file, after the ``Feature`` keyword, the relevant feature will be named..
* Scenarios will be written after the ``Scenario`` keyword. Scenario name must be unique.
* Each scenario should be tagged. Relevant tags should be placed at the top of the script. Like @regression, @smoke.
* The following sample scenario will be followed while the scenario steps are being written.

```gherkin
Given prerequisite
And if there are additional conditions
When the action is taken
And if there is additional action
Then where relevant verifications are made
And additional verifications
```

**Scenario Example**

```gherkin
Given homepage is opened
And click login button
And fill the valid credentials
When click login button
Then verify my account icon
And verify the title is changed to "My Title"
```

# Step Definition Formula

* action + object + location

```gherkin
And click login button on homepage
```


* action + object + value + location

```gherkin
And set email with "m@f.com" on homepage
```


* verification action + object + location

```gherkin
Then verify the new address on my delivery addresses page
```


* verification action + object + value + location

```gherkin
Then verify the new address title is "Home" on my delivery addresses page
```

# Tag Standards

```
@wip = Scenario / feature that has not been developed yet
@smoke = Scenario / feature expected to work within the scope of Smoke
@excluded  = Scenario / feature that no longer exists on the application, but whose scenario has been improved
@bug_fix = Scenario / feature pending bug fix due to an existing bug on the application
@prod  = Scenarios to run in the prod
@regression  = Scenarios to run in the regression
@feature_tag = The tag name to be given to each feature file
@scenario_tag = The tag name to be given to each scenarios
```

# Commit ve PR structure

```
* Branch names must be opened with the ticket id of the job. Example: QA-74
* As much as possible, commits should be committed with clear explanations.
* Commit should be progressed in as small pieces as possible (Atomic). This will make the rollback easier.
* It will be merged into the master after the review of the obligatory reviewers from the PR QA team.
* Before merging to the master, the pipeline will be run on the relevant branch and it will be verified that there is no problem.

```