package com.restassured.commonfiles;

import com.restassured.googleAPI.DeleteplaceTest;


public class Resources {
	
	
	
	
	public static String senddatadeletejson() {
	
		String res="/maps/api/place/delete/json";
	
	return res;
	}
	public static String senddataaddxml() {
		
		String res="/maps/api/place/add/xml";
	
	return res;
	}
	
	
	public static String addBook(String isbn,String aisle) {
		
		String s="{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}";
		
		return s;
	}
	
	public static String deleteBook(String id) {
		
		
		String s="{\r\n" + 
				" \r\n" + 
				"\"ID\" : \""+id+"\"\r\n" + 
				" \r\n" + 
				"} \r\n" + 
				"";
		
		return s;
	}
	
	
	public static String addBug() {
		String s="{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"CCP\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"My 4th Bug\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";
		
		return s;
	}
	
	public static String addBugResource() {
		
		String s="/rest/api/2/issue";
		return s;
	}
	
	public static String addComment() {
		
		String s="{\r\n" + 
				"    \"body\": \"here i an adding comment\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		return s;
	}
	
	public static String addCommentResource(String issueid) {
		
		String s="/rest/api/2/issue/"+issueid+"/comment";
		return s;
	}
	
	public static String updateComment() {
		
		String s="{\r\n" + 
				"    \"body\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eget venenatis elit. Duis eu justo eget augue iaculis fermentum. Sed semper quam laoreet nisi egestas at posuere augue semper.\",\r\n" + 
				"    \"visibility\": {\r\n" + 
				"        \"type\": \"role\",\r\n" + 
				"        \"value\": \"Administrators\"\r\n" + 
				"    }\r\n" + 
				"}";
		
		return s;
	}
	
}
