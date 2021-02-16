package basics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import files.Payload;

public class DynamicAPI {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().queryParam("Key", "qaclick123").headers("Content-Type", "application/json").
		body(Payload.addBook()).when().post("Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String id = js.get("ID");
		
		System.out.println("Added Book id is:- "+id);
		
		
		
		
		
		
	}

}
