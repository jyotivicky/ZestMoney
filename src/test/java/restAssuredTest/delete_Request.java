package restAssuredTest;

import static io.restassured.RestAssured.given;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import request_Utils.request_Object;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
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
import org.testng.annotations.Test;
import io.restassured.RestAssured;

    public class delete_Request {

	  @Test
	  public static void URL_delete_Request() {
		  
		  RestAssured.baseURI = "https://jsonplaceholder.typicode.com/todos";
		  RestAssured.basePath = "/2";
		  
//		  Response response = 
		  
		  given()
		  
			 .when()
			 .delete()
			 
			 .then()
			 .statusCode(200)
			 .statusLine("HTTP/1.1 200 OK")
			 .log().all()
			 .extract().response();
		  
//		  String jsonString = response.asString();
//		  Assert.assertEquals(jsonString.contains("Respnse Message"), true);
	  }
    } 
