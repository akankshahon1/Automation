package org.example;/*
package org.example;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.restassured.RestAssured.*;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        String apassword="Akanksha@1510";
        String[] courseTitles={"Selenium webdriver java","Cypress","Protractor"};

    System.setProperty("webdriver.chrome.driver", "C://Users//e326099//Downloads//chromedriver-win64(1)//chromedriver-win64//chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://accounts.google.com/v3/signin/identifier?opparams=%253Fauth_url%253Dhttps%25253A%25252F%25252Faccounts.google.com%25252Fo%25252Foauth2%25252Fv2%25252Fauth&dsh=S403675884%3A1724398092517171&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&ddm=0&o2v=2&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&response_type=code&scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&service=lso&flowName=GeneralOAuthFlow&continue=https%3A%2F%2Faccounts.google.com%2Fsignin%2Foauth%2Fconsent%3Fauthuser%3Dunknown%26part%3DAJi8hANk1eeySmCGqXZrRShvDgXRKZQbAaVoxH751miWS4PurHlO1Z35O6S8Ez3Obk_A4IRzeBDtpCGNm1ePiNaNcURBmMpthmXfIfkr4On0J8fgq2gXc-X6lcsJ_gQOfBm_K53UZN_HFg3yr2hGi7M6z53ujx6NGs7O6O22qc0B03nE__R28sU3osLNPk9-Qt1kyHZnXGy24p5mmQ9lQFZIWPtmptAuBG28LuMVs3_uDaT3FTvowX_KucP_HP1Ne0i3MkrEvP41xN2INfJyeiaQNKt1K_pf3Tv7vr1nQol06nJzCbKn7rbL6C7XT5oqGyGZfZDUqu1C1mTOUTp60Ebc9c4jnG43gdcJz3yWWHuddyZQfeqtEFzNgShC0ukULk0jW-yPxJ6bP7fRq2hDgjNfXgu2DK9VmNeMtAlvH-1mx5NgoX_MmDJxPEwyaRB8CqRMP49FDbRwE4ybgdP5j_KbqtKU5wVWLQ%26flowName%3DGeneralOAuthFlow%26as%3DS403675884%253A1724398092517171%26client_id%3D692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com%23&app_domain=https%3A%2F%2Frahulshettyacademy.com&rart=ANgoxccmZU8kFoOp-sHvWVrcptOMEuDJGm-6L4j3khbWjJ4-P4AgzKIpbmYm3-L4xp1iCZP87U2AEPwAhjg4dRJtHTWOM5IguXuANtRnp4zAxGK1IrJgTxM");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("akankshahon1");
        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys(apassword);
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
   String url=    driver.getCurrentUrl();
 // String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8wIUKLM6x-LLsdB0mn3ifW-4qhI5APyyOJs5qRkj5mVcHPF7NqhU3xDoaei6iMbYQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
       // https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8wIUKLM6x-LLsdB0mn3ifW-4qhI5APyyOJs5qRkj5mVcHPF7NqhU3xDoaei6iMbYQ&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none
     String partialcode=   url.split("code=")[1];
 String code=   partialcode=   partialcode.split("&scope")[0];
System.out.println(code);



      String accessTokenResponse=  given()
              .urlEncodingEnabled(false)
                .queryParam("code",code)
                .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type","authorization_code")
                .when().log().all()
              .post("https://www.googleapis.com/oauth2/v4/token").asString();




      JsonPath js=new JsonPath(accessTokenResponse);
     String accessToken= js.getString("access_token");
     String response= given().queryParam("access_token ",accessToken)
              .when().get("https://rahulshettyacademy.com/getCourse.php").asString();;
              System.out.println(response);
    }
}*/

//package demo;

import static io.restassured.RestAssured.given;



import java.util.ArrayList;

import java.util.Arrays;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;



import io.restassured.parsing.Parser;

import io.restassured.path.json.JsonPath;

import io.restassured.response.Response;

import io.restassured.response.ResponseBody;

import pojo.Api;

import pojo.GetCourse;





public class Main {



    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQlEd8xW6omsAZ-7tAfwvtzlad4NzkwGIop4Cqf2XoE3isImw8zf_7MXCCukxr5pqICczA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";

        String partialcode=url.split("code=")[1];

        String code=partialcode.split("&scope")[0];

        System.out.println(code);

        String response =

                given()

                        .urlEncodingEnabled(false)

                        .queryParams("code",code)



                        .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")

                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")

                        .queryParams("grant_type", "authorization_code")

                        .queryParams("state", "verifyfjdss")

                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")

                        // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")



                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")

                        .when().log().all()

                        .post("https://www.googleapis.com/oauth2/v4/token").asString();

// System.out.println(response);

        JsonPath jsonPath = new JsonPath(response);

        String accessToken = jsonPath.getString("access_token");

        System.out.println(accessToken);

        String r2=    given().contentType("application/json").

                queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON)

                .when()

                .get("https://rahulshettyacademy.com/getCourse.php")

                .asString();

        System.out.println(r2);



    }



}