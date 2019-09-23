package restAssuredTest;
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

   public class post_Request {
	   
	   public static HashMap map = new HashMap();
	   
	   @BeforeClass
	   public static void Test_post_Request() {
		 
		   map.put("FirstName", request_Object.getFirstName());
		   map.put("LastName", request_Object.getLastName());
		   map.put("UserName", request_Object.getUsername());
		   map.put("Password", request_Object.getPassword());
		   map.put("Email", request_Object.getEmail());
		   
		   RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		   RestAssured.basePath = "/register";
    }
	   @Test
	   public void URL_post_Requst() {
		   
		   given()
			 .contentType("application/json")
			 .body(map)
			 
			 .when()
			   .post()
			   
			 .then()
			  .statusCode(201)
			  .body("SuccessCode",equalTo( "OPERATION_SUCCESS"))
			  .body("Message",equalTo("Operation completed successfully"));	
	     }
      }
