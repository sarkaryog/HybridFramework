package basics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class AddBookWithDataProvider {
	
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().queryParam("Key", "qaclick123").headers("Content-Type", "application/json").body(Payload.dynamicDataToAddBook(isbn, aisle)).
				when().post("Library/Addbook.php").
				then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		String id = js.get("ID");
		System.out.println("Added Book id is:- "+id);
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		
		//Array - collection of data
		//Multidimensional Data - Collection of arrays
		
		return new Object[][] {{"abac","45678"},{"fdsh","98746"},{"ahgkfh", "454646"}};
		
	}

}
