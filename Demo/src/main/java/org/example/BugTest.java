package org.example;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import static io.restassured.RestAssured.*;
public class BugTest {
    
    public static void main(String[] args) {
RestAssured.baseURI="https://wescodist-team-wwhr1rak.atlassian.net/";
        String createIssueResponse= given()
        .header("Content-Type", "application/json")
        .header("Authorization", "Basic YWthbmtzaGEuaG9uQHdlc2NvZGlzdC5jb206QVRBVFQzeEZmR0Ywd2xmQktaQUc5RjR6NWJUU1BldU9jclV5U3hTV2hFY2gwM0xseDRmRXZQNzdCYjVaR1g1Mk1USUFaTjZmb2NBdGpleXpUMnJUUTJrNFg4S1lqcXZSMkJtRkRzdWtLQTN4Y2t3ZmRIb2NaZ3hyU0lkTTZ0LVJ4ejVLelBRNUh1Ym5mWGhsMENNMVJha083OWJMdmkxMnp2aExtNTdsa2pqUVkyalRBbnZPSXJNPUE5NzA2NDU0")
        .body("{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       {\n" +
                "          \"key\": \"KAN\"\n" +
                "       },\n" +
                "       \"summary\": \"Website Items are not working-Automation rest assured\",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Bug\"\n" +
                "       }\n" +
                "   }\n" +
                "}").log().all().post("rest/api/3/issue").then().assertThat().statusCode(201).extract().response().asString();
    JsonPath js=new JsonPath(createIssueResponse);
    String issueId=js.getString("id");
    System.out.println(issueId);

    given()
            .pathParam("key",issueId)
            .header("X-Atlassian-Token","no-check")
            .header("Authorization","Basic YWthbmtzaGEuaG9uQHdlc2NvZGlzdC5jb206QVRBVFQzeEZmR0Ywd2xmQktaQUc5RjR6NWJUU1BldU9jclV5U3hTV2hFY2gwM0xseDRmRXZQNzdCYjVaR1g1Mk1USUFaTjZmb2NBdGpleXpUMnJUUTJrNFg4S1lqcXZSMkJtRkRzdWtLQTN4Y2t3ZmRIb2NaZ3hyU0lkTTZ0LVJ4ejVLelBRNUh1Ym5mWGhsMENNMVJha083OWJMdmkxMnp2aExtNTdsa2pqUVkyalRBbnZPSXJNPUE5NzA2NDU0")
            .multiPart("file",new File("C:/Users/e326099/Pictures/Screenshot 2024-07-23 102040.png"))
            .log().all()
            .post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
    //Add Attachment

    }
}