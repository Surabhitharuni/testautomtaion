Feature: Validating User Apis
  Test the User REST API's


  Scenario: Verify if Api returned success values
    Given User calls "UsersResource" with "GET" http request
    Then the api call returns with a status code 200
    And verify response contains "success" code

  Scenario: Verify if AED returned values should be in range 3.6-3.7
    Given User calls "UsersResource" with "GET" http request
    Then the api call returns with a status code 200
    And verify AED returned values in range "3.6-3.7"
  
   Scenario: Verify if response returned 162 pairs and validate response time and schema
    Given User calls "UsersResource" with "GET" http request
    Then the api call returns with a status code 200
    And verify 162 currency pairs are returned in response
 		And verify response time is not less then 3 seconds then current time
 		And verify API response schema
    