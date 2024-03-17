# Testing of Tallinn-Delivery API

- ***Tallinn-Delivery [URL](http://35.208.34.242) Port: 8080***
- ***API [Documentation](http://35.208.34.242:8080/swagger-ui/index.html/)***

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