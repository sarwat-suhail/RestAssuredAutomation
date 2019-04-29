package com.restassured.googleAPI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.restassured.Resources;

import io.restassured.RestAssured;

public class DeleteplaceTest {

	Properties prop=new Properties();
	
	public String res;
	
	
	
	public void setRes(String res) {
		this.res = res;
	}



	@BeforeTest
	public void init() throws IOException {
		
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\Files\\env.properties");	
		
	prop.load(fis);
	}
	
	
	
	@Test
	public void deletegoogleplace() {
		
		
		RestAssured.baseURI=prop.getProperty("HOST");
		
		
		given().
		queryParam("key", prop.getProperty("KEY")).
		body("{\r\n" + 
				"    \"place_id\":\"8d1e45facc4d8e6f94e522abdc78c354\"           \r\n" + 
				"}").
		
		when().post(Resources.senddatadeletejson()).
		then().assertThat().statusCode(200).and().
		body("status" , equalTo("OK"));
		
		
		
		
	}
	
	
	
	
}
