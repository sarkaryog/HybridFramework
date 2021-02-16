package basics;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJSON {

	public static void main(String[] args) {

		JsonPath js = new JsonPath(Payload.nestedJson());

		// Print no of courses returned by API

		int count = js.getInt("courses.size");
		System.out.println(count);

		// Print purchase amount
		System.out.println("Print purchase amount:- ");
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		// Print title of first course
		System.out.println("Print no of copies sold by RPA Course:- ");
		String firstCourse = js.get("courses[0].title");
		System.out.println(firstCourse);
		System.out.println("---------------------");

		// Print All course titles and their respective Prices
		System.out.println("Print All course titles and their respective Prices:- ");
		for (int i = 0; i < count; i++) {

			System.out.println(js.get("courses[" + i + "].title").toString());
			// syso only expect string argument so we can convert it to string with help of toString method

			int price = js.getInt("courses[" + i + "].price");
			System.out.println(price);
		}
		System.out.println("---------------------");

		// Print no of copies sold by RPA Course
		System.out.println("Print no of copies sold by RPA Course:- ");
		for (int i = 0; i < count; i++) {
			String title = js.get("courses[" + i + "].title");
			if (title.equalsIgnoreCase("RPA")) {
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}

		}

		// Verify if Sum of all Course prices matches with Purchase Amount
		System.out.println("Verify if Sum of all Course prices matches with Purchase Amount:- ");
		int sum=0;
		for (int i = 0; i < count; i++) {
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum+amount;
		}
		System.out.println("Purchased amount is:- "+sum);

	}

}
