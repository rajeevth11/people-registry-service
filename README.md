# people-registry-service
CRUD operation to mange people registry.

## Introduction
This aplication will allowed user to following activities.
  - Save user
  - Retrive user from Social security number
  - Retrieve person from Social security number
  - Retrieve the name of the oldest child

## Requiremens
- Java 8
- IntelliJ IDEA 

## Assumptions
 - Assumed validations will be done from the front end.

## Endpoint suggesstions
 - Create user :Action [POST] http://localhost:8080/people-registry-service/api/people 
 - Update user :Action [PUT] http://localhost:8080/people-registry-service/api/people{SSN} 
 - Retrieve user :Action [GET] http://localhost:8080/people-registry-service/api/people{SSN}
 - Retrieve name of the oldest child :Action [GET] http://localhost:8080/people-registry-service/api/people{SSN}/oldestChild  
