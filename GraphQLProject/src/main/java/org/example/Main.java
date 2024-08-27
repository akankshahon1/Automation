package org.example;
import io.restassured.path.json.JsonPath;
import org.apache.http.util.Asserts;
import org.testng.Assert;
import java.lang.reflect.Type;
import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.*;
public class Main {
    public static void main(String[] args) {
        int characterId=8482;
        int episodeId=9877;
     String response=   given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"query\": \"query ($characterId: Int!, $episodeId: Int!) {\\n  character(characterId: $characterId) {\\n    name\\n    gender\\n    status\\n    type\\n    id\\n  }\\n  location(locationId: 12867) {\\n    name\\n    dimension\\n  }\\n  episode(episodeId: $episodeId) {\\n    name\\n    air_date\\n    episode\\n  }\\n  characters(filters: {name: \\\"Rahul\\\"}) {\\n    info {\\n      count\\n    }\\n    result {\\n      name\\n      type\\n    }\\n  }\\n}\\n\",\n" +
                        "  \"variables\": {\n" +
                        "    \"characterId\": "+characterId+",\n" +
                        "    \"episodeId\":"+episodeId+"\n" +
                        "  }\n" +
                        "}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();
     System.out.println(response);
        JsonPath js=new JsonPath(response);
     String characterName=   js.getString("data.character.name");
        Assert.assertEquals(characterName,"Akanksha");

        //mutation
    String newcharacter="Prajakta";
        String mutationresponse=   given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"query\": \"mutation ($characterName: String!, $locationName: String!, $episodeName: String!) {\\n  createLocation(location: {name: $locationName, type: \\\"south\\\", dimension: \\\"234\\\"}) {\\n    id\\n  }\\n  createCharacter(character: {name: $characterName, type: \\\"Queen\\\", status: \\\"live\\\", species: \\\"fantasy\\\", gender: \\\"female\\\", image: \\\"png\\\", originId: 12856, locationId: 12856}) {\\n    id\\n  }\\n  createEpisode(episode: {name: $episodeName, air_date: \\\"2002 july\\\", episode: \\\"prime\\\"}) {\\n    id\\n  }\\n  deleteLocations(locationIds: [12860]) {\\n    locationsDeleted\\n  }\\n}\\n\",\n" +
                        "  \"variables\": {\n" +
                        "    \"characterName\": \""+newcharacter+"\",\"locationName\": \"Pune\",\n" +
                        "    \"episodeName\": \"HSBC\"\n" +
                        "  }\n" +
                        "}")
                .when().post("https://rahulshettyacademy.com/gq/graphql")
                .then().extract().response().asString();
        System.out.println(response);
        JsonPath js1=new JsonPath(response);
    }
}