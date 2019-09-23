package restAssuredTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;
import org.testng.annotations.BeforeClass;
import request_Utils.request_Object;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import request_Utils.request_Object;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import java.util.HashMap;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matcher.*;

     public class rest_Validation_Types {
    	 
      /*
       * status code validation	 
       */
      @Test(priority=1)
	  public static void URL_json_Request_001() {
		  
		  given()
		  
			 .when()
			 .get("http://jsonplaceholder.typicode.com/posts/5")
			 
			 .then()
			 .statusCode(200);
	  }
      
      /*
       * log report validation
       */
      @Test(priority=2)
      public static void URL_json_Request_002() {
    	  
    	  given()
		  
			 .when()
			 .get("http://jsonplaceholder.typicode.com/posts/5")
			 
			 .then()
			 .statusCode(200)
			 .log().all();
    	  System.out.println("dididiudju");
      }
      
      /*
       * json body data validation
       */
      @Test(priority=3)
      public static void URL_json_Request_003() {
    	  
    	  given()
		  
			 .when()
			 .get("https://reqres.in/api/users/2")
			 
			 .then()
			 .statusCode(200)
			 .body("data.first_name", equalTo("Janet"));
      }
      
      /*
       * multiple content in response body validation
       */
      @Test(priority=4)
      public static void URL_json_Request_004() {
    	  
    	  given()
		  
			 .when()
			 .get("https://reqres.in/api/users")
			 
			 .then()
			 .body("data.first_name", hasItems("Janet","George","Emma"));
      }
      
      /*
       *setting parameterAndHeader
       */
      @Test(priority=5)
      public static void URL_json_Request_005() {
    	  
    	  given()
    	      
    	     .param("MyName", "Jyoti")
    	     .header("MyHeader","Indian")
		  
			 .when()
			 .get("https://reqres.in/api/users/3")
			 
			 .then()
			 .statusCode(200)
			 .body("data.first_name", equalTo("Emma"))
			 .log().all();
      }
    }
  

     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     