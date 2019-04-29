package com.restassured.libraryAPI;
import org.testng.annotations.Test;

import com.restassured.commonfiles.Resources;
import com.restassured.commonfiles.ReusableMethods;

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

public class ValidationOfResponseInXmlTest {


	@Test
	public void postData() throws IOException {
		
	String payLoaddata=	generateStringFromResource("E:\\postdata.xml");
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response res=given().
		
		queryParam("key", " qaclick123").
		
		body(payLoaddata).
		
		when().
		post(Resources.senddataaddxml()).
		then().assertThat().and().statusCode(200).and().contentType(ContentType.XML).and().
		extract().response();
		String[] s=Resources.senddataaddxml().split("/");
		String ls=s[s.length-1];
		
		
		Object o=ReusableMethods.rawToXmlJson(res,ls);
		
		if(o instanceof XmlPath) {
			
			XmlPath x=(XmlPath)o;
			
	String finalstring=	x.get("response.place_id");
	System.out.println(finalstring);
		}else {
        JsonPath x=(JsonPath)o;
			
			String finalstring=x.get("response.place_id");
			System.out.println(finalstring);
		}
	

		
		
	}
	public String generateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
	
}
