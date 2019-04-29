package com.restassured.libraryAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.restassured.Resources;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LibraryApiDynamicallyAddVariableToPayloadTest {
	public String id;
	@Test(priority=1)
	public void addBook() {
	RestAssured.baseURI="http://216.10.245.166";
	
	Response resp=given().
	body(com.restassured.Resources.addBook("asdfw","12345" )).
	when().
	post("/Library/Addbook.php ").
	then().assertThat().statusCode(200).
	extract().response();
	
	JsonPath rep=com.restassured.ReusableMethods.rawToJson(resp);
	 id=rep.get("ID");
	System.out.println(id);
	}
	
	@Test(priority=2)
	public void deleteBook() {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp=given().
		body(com.restassured.Resources.deleteBook(id)).
		when().
		post("/Library/DeleteBook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath rep=com.restassured.ReusableMethods.rawToJson(resp);
		String id=rep.get("msg");
		System.out.println(id);
		
	}
}


