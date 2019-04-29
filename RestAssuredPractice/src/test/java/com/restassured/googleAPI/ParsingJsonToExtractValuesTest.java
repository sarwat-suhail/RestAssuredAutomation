package com.restassured.googleAPI;
import org.testng.annotations.Test;

import com.restassured.Resources;
import com.restassured.ReusableMethods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ParsingJsonToExtractValuesTest {


	@Test
	public void postData() throws IOException {
		
	//String payLoaddata=	generateStringFromResource("E:\\postdata.xml");
		
	RestAssured.baseURI="https://maps.googleapis.com";
	
Response res=given().
	param("location","-33.8670522,151.1957362").
	param("radius","500").
	param("key","AIzaSyAmudIBFVhA7IgWD07PXuQl3LsIfUOsnj4").
	when().
	get("/maps/api/place/nearbysearch/json").
	then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
	body("results[0].name", equalTo("Sydney")).and().
	body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().header("server", "scaffolding on HTTPServer2").
	extract().response();
		
	JsonPath js=ReusableMethods.rawToJson(res);
	
	int count=js.get("results.size()");
	System.out.println(count);
		
	for(int i=0;i<count;i++) {
		
	String s=js.get("results["+i+"].name");		
		System.out.println(s);
	}
	
	
	
	
		
		}
	

		
	
	public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	
}
