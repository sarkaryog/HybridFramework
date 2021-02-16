package files;

public class Payload {
	
	public static String AddPlace() {
		
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383495,\r\n" + 
				"    \"lng\": 33.427962\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontlinee housse\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3737\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://amazon.com\",\r\n" + 
				"  \"language\": \"French-EN\"\r\n" + 
				"}\r\n" + 
				"";
		
	}
	
	public static String UpdatePlace() {
		return "{\r\n" + 
				"\"place_id\":\"c1011f4b019869a9c0cf3babc01c0ae0\",\r\n" + 
				"\"address\":\"Rathra rewa MP\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"";
	}
	
	public static String nestedJson() {
		return "{\r\n" + 
				"\r\n" + 
				"\"dashboard\": {\r\n" + 
				"\r\n" + 
				"\"purchaseAmount\": 910,\r\n" + 
				"\r\n" + 
				"\"website\": \"rahulshettyacademy.com\"\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"\"courses\": [\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Selenium Python\",\r\n" + 
				"\r\n" + 
				"\"price\": 50,\r\n" + 
				"\r\n" + 
				"\"copies\": 6\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"Cypress\",\r\n" + 
				"\r\n" + 
				"\"price\": 40,\r\n" + 
				"\r\n" + 
				"\"copies\": 4\r\n" + 
				"\r\n" + 
				"},\r\n" + 
				"\r\n" + 
				"{\r\n" + 
				"\r\n" + 
				"\"title\": \"RPA\",\r\n" + 
				"\r\n" + 
				"\"price\": 45,\r\n" + 
				"\r\n" + 
				"\"copies\": 10\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"]\r\n" + 
				"\r\n" + 
				"}";
		
	}
	
	public static String addBook(){
		String body = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Selenium Automation with Java\",\r\n" + 
				"\"isbn\":\"bczszd\",\r\n" + 
				"\"aisle\":\"229\",\r\n" + 
				"\"author\":\"Yogesh S\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"";
		return body;
}
	
	public static String dynamicDataToAddBook(String isbn, String aisle) {
		
		String body = "{\r\n" + 
				"\r\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
				"\"isbn\":\""+isbn+"\",\r\n" + 
				"\"aisle\":\""+aisle+"\",\r\n" + 
				"\"author\":\"John foe\"\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"";
		return body;
	}
 

	}
	

