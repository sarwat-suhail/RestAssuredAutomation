package com.restassured.libraryAPI;

import org.testng.annotations.Test;

import com.restassured.commonfiles.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LibraryApiAddBookTest {
	
	@Test
	public void addBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp=given().
		body("{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\"bcdef\",\r\n" + 
				"\"aisle\":\"227\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}").
		when().
		post("/Library/Addbook.php ").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath rep=com.restassured.commonfiles.ReusableMethods.rawToJson(resp);
		String id=rep.get("ID");
		System.out.println(id);
		
		
	}
	
	
	
	

}
