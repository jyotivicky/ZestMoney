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

    public class XML_validation {
     
	  /*
	   * to test single content in xml
	   */
	  @Test(priority=1)
	  public static void Test_XML_Validation_001() {
		  
		  given()

			 .when()
			   .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
			   
			 .then()
			 .body("CUSTOMER.FIRSTNAME", equalTo("Sue"));
			 //.log().all();
	     }
	  
	  /*
	   * to test multiple content in xml 
	   */
	  @Test(priority=2)
	  public static void Test_XML_Validation_002() {
		  
		  given()

			 .when()
			   .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
			   
			 .then()
			 .body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
			 .body("CUSTOMER.LASTNAME", equalTo("Fuller"))
			 .body("CUSTOMER.STREET", equalTo("135 Upland Pl."))
			 .body("CUSTOMER.CITY", equalTo("Dallas"));
			 //.log().all();
	     }
	  
	  /*
	   * to test multiple content in xml in one go
	   */
	  @Test(priority=3)
	  public static void Test_XML_Validation_003() {
		  
		  given()

			 .when()
			   .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
			   
			 .then()
			 .body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"));
	     }
	  
	  /*
	   * to test XML response body using XML path 
	   */
	  @Test(priority=4)
	  public static void Test_XML_Validation_004() {
		  
		  given()

			 .when()
			   .get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10")
			   
			 .then()
			 .body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
	     }
	  
	  /*
	   * to test XML response body using second type XML path 
	   */
	  @Test(priority=5)
	  public static void Test_XML_Validation_005() {
		  
		  given()

			 .when()
			   .get("http://www.thomas-bayer.com/sqlrest/INVOICE/")
			   
			 .then()
			 .body(hasXPath("/INVOICEList/INVOICE[text()='23']"))
			 .log().all();		 
	     }
     }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  