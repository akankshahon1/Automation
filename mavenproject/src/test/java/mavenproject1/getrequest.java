package mavenproject1;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class getrequest {
	@Test
    public static void GetApiTest() {

        // Performing GET request and validating its response.
        given()
                // Specifying the Base URI.
                .baseUri("https://reqres.in/api")
                .contentType(ContentType.JSON)
                .when()
                //HTTP Request Method.
                .get("/users/2")
                .then()
                //Ensuring that status code is 200 OK.
                .statusCode(200)
                // Validating Id value.
                .body("data.id", equalTo(2))
                // Validating Email value.
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                // Validating First Name value.
                .body("data.first_name", equalTo("Janet"))
                // Validating Last Name value.
                .body("data.last_name", equalTo("Weaver"))
                // Ensuring that Avatar value is not null.
                .body("data.avatar", notNullValue())
                // Log response details
                .log().all();
    }

}
