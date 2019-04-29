package com.restassured.googleAPI;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DataProviderDynamicJsonTest {
	public String id;
	@Test(priority=1,dataProvider="getData")
	public void addBook(String isbn,String aisle) {
	RestAssured.baseURI="http://216.10.245.166";
	
	Response resp=given().
	body(com.restassured.Resources.addBook(isbn,aisle )).
	when().
	post("/Library/Addbook.php ").
	then().assertThat().statusCode(200).
	extract().response();
	
	JsonPath rep=com.restassured.ReusableMethods.rawToJson(resp);
	 id=rep.get("ID");
	System.out.println(id);
	}
	@Test(priority=2,dataProvider="getData")
	public void deleteBook(String isbn,String aisle) {
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response resp=given().
		body(com.restassured.Resources.deleteBook(isbn+aisle)).
		when().
		post("/Library/DeleteBook.php").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath rep=com.restassured.ReusableMethods.rawToJson(resp);
		String id=rep.get("msg");
		System.out.println(id);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
	return	new Object[][] {{"asdse","3456"},{"ytrfr","7678"},{"hgtyfr","34209"}};
		
	}
	
	
}
