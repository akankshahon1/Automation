package org.example;
import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/*
import files.ReUsableMethods;
import files.payload;*/

public class Main {

        public static void main(String[] args) throws IOException {
            // TODO Auto-generated method stub
// validate if Add Place API is workimg as expected

            //given - all input details
            //when - Submit the API -resource,http method
            //Then - validate the response
            RestAssured.baseURI= "https://rahulshettyacademy.com";



            /*String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                    .body(payload.AddPlace()).when().post("maps/api/place/add/json")
                    .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                    .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

            */
            //Content of file to string-content of file can convert into Byte-byte data to string
            String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                    .body(new String(Files.readAllBytes(Paths.get("C:\\Users\\e326099\\Downloads\\addPlace.json")))).when().post("maps/api/place/add/json")
                    .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                    .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
                   // .body("msg", equalTo("Address successfully updated"));


            //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
            System.out.println(response);
            JsonPath js=new JsonPath(response);     //for parsing json
            String placeId=js.getString("place_id");
            System.out.println(placeId);

            //Update place
            String newAddress="Summer Walk, Africa";
            given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
                    .body("{\n" +
                            "\"place_id\":\""+placeId+"\",\n" +
                            "\"address\":\""+newAddress+"\",\n" +
                            "\"key\":\"qaclick123\"\n" +
                            "}").
                    when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated"));

            //Get Place

            String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
                    .queryParam("place_id",placeId)
                    .when().get("maps/api/place/get/json")
                    .then().assertThat().log().all().statusCode(200).extract().response().asString();
            JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
            String actualAddress=js1.getString("address");
           // String actualAddress =js1.getString("address");
            System.out.println(actualAddress);
            //Cucumber Junit, Testng
           Assert.assertEquals(actualAddress,newAddress);


        }

    }
