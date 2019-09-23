package restAssuredTest;

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

    public class put_Request {
  
	public static HashMap map = new HashMap();
	
	  @BeforeClass
	  public static void Test_put_Request() {
		  
		   map.put("email", request_Object.getEMPemail());
		   map.put("first_name", request_Object.getEMPfirstname());
		   map.put("last_name", request_Object.getEMPlastname());
		   
		   RestAssured.baseURI = "https://reqres.in/api/users";
		   RestAssured.basePath = "/3";
	  }
	  
	  @Test
	   public void URL_post_Requst() {
		   
		   given()
			 .contentType("application/json")
			 .body(map)
			 
			 .when()
			   .put()
			   
			 .then()
			  .statusCode(200)
			  .log().all();
	     }
     }
