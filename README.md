# Testing of Tallinn-Delivery API

- ***Tallinn-Delivery API [URL](http://35.208.34.242:8080) Port: 8080***
- ***Tallinn-Delivery API [Documentation](http://35.208.34.242:8080/swagger-ui/index.html)***

# Dependencies

- ***Maven, version: 3.8.5***
- ***Java, version: 21***
- ***Maven Surefire Plugin, version: 2.22.2***
- ***REST Assured, version: 5.3.2***
- ***Apache Commons Configuration, version: 1.10***
- ***Apache Maven Compiler Plugin, version: 3.8.0***
- ***JUnit Jupiter Engine, version: 5.5.2***
- ***JUnit Jupiter Params, version: 5.5.2***
- ***Allure JUnit 5, version: 2.13.1***
- ***Allure Maven, version: 2.10.0***
- ***AspectJ Weaver, version: 1.9.4***
- ***Gson, version: 2.10.1***
- ***Project Lombok, version: 1.18.30***

## Check-lists

### /Get all orders

| № | Check name                                    | Status |
|---|-----------------------------------------------|--------|
| 1 | Get all orders information and check response | Pass   |

### /Create an order

| № | Check name                                               | Status |
|---|----------------------------------------------------------|--------|
| 1 | Create order with correct random data and check response | Pass   |

### /Delete order by ID

| № | Check name                             | Status |
|---|----------------------------------------|--------|
| 1 | Delete random order and check response | Pass   |

---

# HW-17

# Testing of Tallinn-Delivery UI

- ***Tallinn-Delivery [URL](http://35.208.34.242:3000) Port: 3000***

## Web UI checks

### Login

| № | Check name                                                                       | Status |
|---|----------------------------------------------------------------------------------|--------|
| 1 | Login field. Check the absence of errors when using a valid login                | Pass   |
| 2 | Login field. Check the error message when using an invalid login                 | Pass   |
| 3 | Login field. Check the error message when using an empty login field             | Pass   |
| 4 | Password field. Check the absence of errors when using a valid password          | Pass   |
| 5 | Password field. Check the error message when using an invalid password           | Pass   |
| 6 | Password field. Check the error message when using an empty password field       | Pass   |
| 7 | Sign-in button. Check of working the button, when using valid login and password | Pass   |
| 8 | Sign-in button. Check of deactivation the button when using an invalid login     | Pass   |
| 9 | Sign-in button. Check of deactivation the button when using an invalid password  | Pass   |

### Web Element names & Xpath locators

| № | Element name                 | Xpath                                                                     |
|---|------------------------------|---------------------------------------------------------------------------|
| 1 | Username input field         | //*[@data-name="username-input"]                                          |
| 2 | Username input error message | //*[@data-name="username-input"]/..//*[@data-name="username-input-error"] |
| 3 | Password input field         | //*[@data-name="password-input"]                                          |
| 4 | Password input error message | //*[@data-name="password-input"]/..//*[@data-name="username-input-error"] |
| 5 | Sign-in button               | //*[@data-name="signIn-button"]                                           |

### An exercise:

### make Xpath's for the [html](https://drive.google.com/file/d/1GeOv7Az1KVdnVY99m2QsfOgcdt_Y_NpP/view?usp=sharing) document

| № | Exercise name                                                                 | Xpath                                  |
|---|-------------------------------------------------------------------------------|----------------------------------------|
| 1 | Select all \<td\> elements that contain names (Name)                          | //td[@class="td3"]                     |
| 1 | Select all \<tr\> elements , whose data-qa attribute starts with "amount-"    | //tr[starts-with(@data-qa, "amount-")] |
| 2 | Select all \<tr\> elements containing \<td\> element with the text "John Doe" | //tr/td//*[text()="John Doe"]          |

---

**Configuration**

1. Open the `src/test/resources/application.yaml` file.
2. Update with your credentials:

    ```yaml
    general:
      username: YOUR_API_KEY_HERE
    ```

**Usage**

```
mvn clean test  
mvn allure:serve 
```

To run a specific test class using Maven, execute the following command in the terminal:

```
mvn clean test -Dtest=TestClassName