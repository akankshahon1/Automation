package org.example;

import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.log4j.BasicConfigurator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
    @Test(dataProvider="BooksData")
    public void addbook(String isbn,String aisle)
    {
       // BasicConfigurator.configure();

        RestAssured.baseURI = "http://216.10.245.166";
        String response= given().log().all().header("Content-Type", "application/json")
        .body(payload.Addbook(isbn,aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id=js.get("ID");
        System.out.println(id);
    }
    //Parameterize the API tests with multiple date sets
    @DataProvider(name="BooksData")
    public Object[][] getData()
    {
        //array-collection of elements
        //multi dimensional array=collection of arrays
        return new Object[][]{{"bg","5311"},{"bhgf","87"},{"lo","09"}};
    }
}
