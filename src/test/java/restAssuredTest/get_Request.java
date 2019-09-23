package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

  public class get_Request {
	  
  @Test
  public void URL_get_Request() {
	  
	  given()
	  
		 .when()
		 .get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		 
		 .then()
		 .statusCode(200)
		 
		 .and()
		 .statusLine("HTTP/1.1 200 OK")
		 
		 .and()
		 .assertThat().body("City",equalTo("Hyderabad"))
		 
		 .and()
		 .headers("Content-Type",equalTo("application/json"));	
      }
   }
