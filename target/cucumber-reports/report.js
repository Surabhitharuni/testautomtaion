$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/validations.feature");
formatter.feature({
  "name": "Validating User Apis",
  "description": "  Test the User REST API\u0027s",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify if Api returned success values",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User calls \"UsersResource\" with \"GET\" http request",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.user_calls_with_http_request(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the api call returns with a status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.the_api_call_returns_with_a_status_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify response contains \"success\" code",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.verify_response_contains_success_code(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify if AED returned values should be in range 3.6-3.7",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User calls \"UsersResource\" with \"GET\" http request",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.user_calls_with_http_request(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the api call returns with a status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.the_api_call_returns_with_a_status_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify AED returned values in range \"3.6-3.7\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.verify_AED_returned_values_in_range(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify if response returned 162 pairs and validate response time and schema",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User calls \"UsersResource\" with \"GET\" http request",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.user_calls_with_http_request(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the api call returns with a status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.the_api_call_returns_with_a_status_code(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify 162 currency pairs are returned in response",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.verify_162_currency_pairs_are_returned_in_response(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify response time is not less then 3 seconds then current time",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.verify_response_time_is_not_less_then_3_seconds_then_current_time(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify API response schema",
  "keyword": "And "
});
formatter.match({
  "location": "stepdefinitio.StepDefinitions.verify_API_response_schema()"
});
formatter.result({
  "status": "passed"
});
});