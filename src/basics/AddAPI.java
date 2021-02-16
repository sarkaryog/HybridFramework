package basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*; //equalTo method 


import files.Payload;

public class AddAPI {

	public static void main(String[] args) {

		// Validate if Add place API is working as expected

		// Given - all input details
		// when - submit the API, , http method 
		// Then - Validate the response
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("Key", "qaclick123").headers("Content-Type", "application/json")
		.body(Payload.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString();
		
		// If we remove log().all() after when() then response is not capture in console, we can save that response as string as above
		
		// We can remove headers type if those are hidden in postman 
		
		System.out.println(response);
		System.out.println("-------------------");
		
		// converting above string in json format
		JsonPath js = new JsonPath(response); // for parsing string to json
		String  placeID = js.getString("place_id");
		System.out.println("Place ID = "+placeID);
		
		// slashes comes in body to tell java that " is character not a string 
		
		// next scenario - Add place > Update place with new address > get place to validate if new address is present in response
		
		// Update place
		
		String newAddress = "Rathara Rewa MP 486001";
		
		given().log().all().queryParam("Key", "qaclick123").headers("Content-Type", "application/json").
		body("{\r\n" + 
				"\"place_id\":\""+placeID+"\",\r\n" + 
				"\"address\":\""+newAddress+" \",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		String getResponse = given().queryParam("Key", "qaclick123").queryParam("place_id", placeID).when().get("maps/api/place/get/json").then().
		assertThat().log().all().statusCode(200).extract().response().asString();
		
		js = new JsonPath(getResponse);
		String actualAddress = js.getString("address");
		System.out.println(actualAddress);
	}

}
