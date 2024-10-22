package Demo;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

//import io.cucumber.tagexpressions.Expression;
 
 
@RunWith(SerenityRunner.class)
public class TestApi {
	
	@Before
	public static void init()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users/";
		
		
	}
	
	
	@Title("Sending Get request test")
	@Test
	public void testGetRequest()
	{
		Response response= SerenityRest.given().when().get("2");
		response.prettyPrint();
	}
	
 
}
 