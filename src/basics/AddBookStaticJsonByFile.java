package basics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class AddBookStaticJsonByFile {
	
	public static String genrateStringFromExternalStaticJsonFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}
	//
	@Test
	public void addBook() throws IOException {
		RestAssured.baseURI="http://216.10.245.166";
		Response response=given().queryParam("Key", "qaclick123").headers("Content-Type", "application/json").
		body(genrateStringFromExternalStaticJsonFile("C:\\Users\\Vidya Bittu\\Documents\\StaticJson.txt")).
		when().post("Library/Addbook.ph").
		then().log().all().assertThat().statusCode(200).extract().response();
		
		JsonPath js = new JsonPath(response.asString());
		String id = js.get("ID");
		System.out.println("Book Id is  :- "+id);
		
				
	}

}
