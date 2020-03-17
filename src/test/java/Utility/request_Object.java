package request_Utils;

import org.apache.commons.lang3.RandomStringUtils;

     public class request_Object {
	   /*
	    * generating data for post request
	    */
	 public static String getFirstName() {
		 String generateString = RandomStringUtils.randomAlphabetic(1);
		 return ("jyoti"+generateString);
	 }
	 
	 public static String getLastName() {
		 String generateString = RandomStringUtils.randomAlphabetic(1);
		 return ("Das"+generateString);
	 }
	 
	 public static String getUsername() {
		 String generateString = RandomStringUtils.randomAlphabetic(3);
		 return ("Vicky"+generateString);
	 }
	 
	 public static String getPassword() {
		 String generateString = RandomStringUtils.randomAlphabetic(3);
		 return ("Vicky"+generateString);
	 }
	 
	 public static String getEmail() {
		 String generateString = RandomStringUtils.randomAlphabetic(3);
		 return ("vicky"+generateString+"@gmail.com");
	 }
	 
	 /*
	  * **************************************************************
	  */
	 
	 public static String getEMPfirstname() {
		 String generateString = RandomStringUtils.randomAlphabetic(3);
		 return (generateString);
	 }
	 
	 public static String getEMPlastname() {
		 String generateString = RandomStringUtils.randomAlphabetic(3);
		 return ("Vicky"+generateString);
	 }
	 
	 public static String getEMPemail() {
		 String generateString = RandomStringUtils.randomAlphabetic(2);
		 return ("jyoti"+generateString+"@yahoo.com");
	 }
	 
   }