package com.restassured.twitterAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetTweetTest {

	String ConsumerKey="DyP6MphHFwfk95WDkqq7flsc0";
	String ConsumerSecret="hjIENEIV97olRcIii0yniNrUZUWylSs4lPYTkerRzKLPxN8QLV";
	String AccessToken="110607723-ue8BzsLOanPaYz5cFeUocfoorzl39qkzbNKafHds";
	String TokenSecret="uKE6UHRq0b33JAw2ocg21SJhcKojBxuyI0FpJOwSUuqpt";
	String id;
	@Test
	public void getTweet() {
		
		
		RestAssured.baseURI="https://api.twitter.com";
		
		Response res=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret).
		queryParam("count", "1").
		when().
		get("1.1/statuses/home_timeline.json").
		then().extract().response();
		
		String tweettextraw=res.asString();
		JsonPath jp=new JsonPath(tweettextraw);
		
	String id=jp.getString("id");
	String tweettext=jp.getString("text");
	System.out.println(tweettext);
	}
	
	
	@Test
	public void createTweet() {
		
		
		RestAssured.baseURI="https://api.twitter.com";
		
		Response res=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret).
		queryParam("status", "I created this tweet from RestAssured API").
		//body("{\"status\":\"i am tweeting from restassured\"}").
		when().
		post("/1.1/statuses/update.json").
		then().extract().response();
		
		String tweettextraw=res.asString();
		JsonPath jp=new JsonPath(tweettextraw);
		
	id=jp.getString("id");
	//String tweettext=jp.getString("text");
	System.out.println("this tweet is created ");
	System.out.println(id);
	}
	
	@Test
	public void deleteTweet() {
		
		createTweet();
		RestAssured.baseURI="https://api.twitter.com";
		
		Response res=given().auth().oauth(ConsumerKey, ConsumerSecret, AccessToken, TokenSecret).
		//queryParam("status", "I created this tweet from RestAssured API").
		//body("{\"status\":\"i am tweeting from restassured\"}").
		when().
		post("1.1/statuses/destroy/"+id+".json").
		then().extract().response();
		
		String tweettextraw=res.asString();
		JsonPath jp=new JsonPath(tweettextraw);
		
	String id=jp.getString("id");
	String tweettext=jp.getString("text");
	System.out.println("below tweet is deleted");
	System.out.println(tweettext);
	}
}
