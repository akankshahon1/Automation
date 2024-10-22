import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
public class sample_test {
	@Test
	public void getrequest() {
	given()
	.when()
	.get("https://www.jagranjosh.com/general-knowledge/math-riddles-only-genius-can-solve-these-1661003650-1")
	.then()
	.statusCode(200);
	 }
}
