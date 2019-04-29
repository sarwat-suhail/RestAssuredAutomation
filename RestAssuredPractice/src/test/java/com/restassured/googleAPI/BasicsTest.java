package com.restassured.googleAPI;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class BasicsTest {

	
	@Test
	public void TestApi() {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key","AIzaSyAmudIBFVhA7IgWD07PXuQl3LsIfUOsnj4").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name", equalTo("Sydney")).and().
		body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().header("server", "scaffolding on HTTPServer2");
		
		
		
		

	}

	

}
