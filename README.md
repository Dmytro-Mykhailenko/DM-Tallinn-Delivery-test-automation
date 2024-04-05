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
- ***Selenide, version: 7.2.3***

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

### Login page

| №  | Check name                                                                   | Status |
|----|------------------------------------------------------------------------------|--------|
|    | **Login field**                                                              |        |
| 1  | Check the absence of errors if using valid login length                      | Pass   |
| 2  | Check the error message if the login too short                               | Pass   |
| 3  | Check the impossibility of exceeding the maximum allowed login length        | Pass   |
| 4  | Check the error message if clear login field                                 | Pass   |
|    | **Password field**                                                           |        |
| 5  | Check the absence of errors if using valid password length                   | Pass   |
| 6  | Check the error message if the password too short                            | Pass   |
| 7  | Check the impossibility of exceeding the maximum allowed password length     | Pass   |
| 8  | Check the error message if clear password field                              | Pass   |
|    | **Sign-in button**                                                           |        |
| 9  | Check of working the sign-in button, if using valid login and password       | Pass   |
| 10 | Check of deactivation the sign-in button if using an invalid login           | Pass   |
| 11 | Check of deactivation the sign-in button if using an invalid password        | Pass   |
|    | **Login**                                                                    |        |
| 12 | Login with correct credentials and check the Create button on the order page | Pass   |
| 13 | Login with incorrect credentials and check the Incorrect credentials pop-up  | Pass   |

### Web Element names & Xpath locators

| № | Element name                 | Xpath                                                                     |
|---|------------------------------|---------------------------------------------------------------------------|
| 1 | Username input field         | //*[@data-name="username-input"]                                          |
| 2 | Username input error message | //*[@data-name="username-input"]/..//*[@data-name="username-input-error"] |
| 3 | Password input field         | //*[@data-name="password-input"]                                          |
| 4 | Password input error message | //*[@data-name="password-input"]/..//*[@data-name="username-input-error"] |
| 5 | Sign-in button               | //*[@data-name="signIn-button"]                                           |
| 6 | Incorrect credentials pop-up | //*[@data-name="authorizationError-popup-close-button"]                   |
| 7 | Create order button          | //*[@data-name="createOrder-button"]                                      |
| 8 | Log-out button               | //*[@data-name="logout-button"]                                           |

### An exercise:

### make Xpath's for the [html](https://drive.google.com/file/d/1GeOv7Az1KVdnVY99m2QsfOgcdt_Y_NpP/view?usp=sharing) document

| № | Exercise name                                                                 | Xpath                                  |
|---|-------------------------------------------------------------------------------|----------------------------------------|
| 1 | Select all \<td\> elements that contain names (Name)                          | //td[@class="td3"]                     |
| 2 | Select all \<tr\> elements , whose data-qa attribute starts with "amount-"    | //tr[starts-with(@data-qa, "amount-")] |
| 3 | Select all \<tr\> elements containing \<td\> element with the text "John Doe" | //tr/td//*[text()="John Doe"]          |

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