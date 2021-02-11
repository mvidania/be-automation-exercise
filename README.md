# REST API AUTOMATION EXERCISE

Java application based on SpRing-Boot, REST Assured and Cucumber.

It tests an open API https://petstore.swagger.io/ the following actions:

* Get "available" pets. Assert expected result
* Post a new available pet to the store. Assert new pet added.
* Update this pet status to "sold". Assert status updated.
* Delete this pet. Assert deletion.

## Getting Started

Prerequisites before you run the application:
* Install Java JDK 1.8
* Install Maven


### Installing

Download the project from https://github.com/mvidania/be-automation-exercise.git


## Project Structure

### Packages
####main
* services -> Classes that retrieve data in java objects.
* populator -> Classes to fill java objects based on our needs
* models -> Classes that map json responses from the api.
* helpers -> Classes that help us with common actions or custom validators.
* api -> Classes that make requests and get responses from the api.

####test
* gherkinsteps -> Classes that contains the methods triggered by runner classes.
* runners -> Classes that run the steps defined in gherkinsteps.

####test/resources
* /features -> This folder contains gherkin features that describes the 
  scenario and actions executed in gherkinsteps classes.

## Running the tests

Open new terminal from command-Line, go to the project root and execute.

```
mvn test
```
The test will execute automatically.

You will see the steps and results on the terminal.

## Author

* [Miguel Vidania](https://github.com/mvidania/)

