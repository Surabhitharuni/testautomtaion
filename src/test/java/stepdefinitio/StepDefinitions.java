package stepdefinitio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
//import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import support.AppProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.testng.Assert;
import org.junit.Assert;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


public class StepDefinitions extends AppProperties {

	private final static Logger log = LogManager.getLogger(StepDefinitions.class.getName());
    private RequestSpecification res=given();
    private Response response;

    

    
    @Given("User calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
    	String url=resourceMapping(resource);
        invokeRequest(url,method,null);
    }

    @Then("the api call returns with a status code {int}")
    public void the_api_call_returns_with_a_status_code(int code) {
        log.info("user checks response status");
        int responseCode=response.then().extract().statusCode();
        Assert.assertEquals(responseCode, code);
        
    }
    @And("verify response contains {string} code")
    public void verify_response_contains_success_code(String code) {
    	log.info("user checks success code in response");
       String value=stringToJson(response.asString()).get("result")+"";
        Assert.assertEquals(value, code);
        
    }

    @And("verify AED returned values in range {string}")
    public void verify_AED_returned_values_in_range(String code) {
    	log.info("user checks success code in response");
       String value=stringToJson(response.asString()).get("rates.AED")+"";
       String [] limit=code.split("-");
       Boolean flag=false;
       
       if(Double.parseDouble(limit[0])<Double.parseDouble(value) && Double.parseDouble(limit[1])>Double.parseDouble(value)) {
    	   flag=true;
       }
       Assert.assertEquals(flag,Boolean.TRUE);
    }

    @And("verify {int} currency pairs are returned in response")
    public void verify_162_currency_pairs_are_returned_in_response(int count) {
    	log.info("verify 162 currency pairs are returned in response");
       Map<String,String> value=stringToJson(response.asString()).get("rates");
      Assert.assertEquals(value.size(),count);
    }
    
    @And("verify response time is not less then {int} seconds then current time")
    public void verify_response_time_is_not_less_then_3_seconds_then_current_time(int time) {
    	log.info("verify response time is not less then 3 seconds then current time");
    	
       String value=stringToJson(response.asString()).get("time_last_update_utc");
       long respTime=response.time();
       Assert.assertEquals(respTime<time*1000l,Boolean.TRUE);
       
      }
    @And("verify API response schema")
    public void verify_API_response_schema() {
    	log.info("verify API response schema");
    	response.then().assertThat().body(JsonSchemaValidator.
     	      matchesJsonSchema(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\resources\\schema.json")));
       
      }
    private void invokeRequest(String resource, String method, String id) {
        String pathId = (id != null) ? "/" + id : "";
         if (method.equalsIgnoreCase("GET")){

            response = res.when().get(resource);
                        
        }
    }
    private String resourceMapping(String resource) {
    	String url="";
    	if(resource.equals("UsersResource")) {
    		url=AppProperties.getBaseURL()+"/v6/latest/USD";
    	}
		return url;
    	
    }
    public static JsonPath stringToJson(String value) {
        return new JsonPath(value);
    }
}