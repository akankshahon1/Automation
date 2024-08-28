package demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.Orders;
import pojo.orderDetails;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ECommerceAPITest {

    public static void main(String[] args) {
        RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserEmail("something1@gmail.com");
        loginRequest.setUserPassword("Akanksha@1");

       RequestSpecification reqLogin= given().relaxedHTTPSValidation().log().all().spec(req).body(loginRequest);
      LoginResponse loginResponse= reqLogin.when().post("/api/ecom/auth/login")
              .then().log().all().extract().response().as(LoginResponse.class);
      String token= loginResponse.getToken();
      String userId=loginResponse.getUserId();

       //Add product
        RequestSpecification addProductBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token)
                .build();

       RequestSpecification reqAddProduct= given().log().all().spec(addProductBaseReq).param("productName","Shirt")
                .param("productAddedBy",userId)
                .param("productCategory","fashion")
                .param("productSubCategory","shirts")
                .param("productPrice","500")
                .param("productDescription","Levi's")
                .param("productFor","women")
                .multiPart("productImage",new File("C:/Users/e326099/Postman/files/images.jpg"));

     String addProductResponse = reqAddProduct.when().post("/api/ecom/product/add-product")
               .then().log().all().extract().response().asString();

       JsonPath js = new JsonPath(addProductResponse);
      String productId= js.get("productId");

    //create order
        RequestSpecification createOrderBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token).setContentType(ContentType.JSON).build();

        orderDetails orderdetails = new orderDetails();
        orderdetails.setCountry("India");
        orderdetails.setProductOrderedId(productId);

        List<orderDetails> orderdetailsList = new ArrayList<orderDetails>();
        orderdetailsList.add(orderdetails);

        Orders orders=new Orders();
        orders.setOrders(orderdetailsList);
       RequestSpecification createOrderReq= given().log().all().spec(createOrderBaseReq).body(orders);
 String responseAddOrder = createOrderReq.when().post("/api/ecom/order/create-order").then().log().all().extract().response().asString();
   System.out.println(responseAddOrder);

    //delete product
        RequestSpecification deleteProdBaseReq= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token).setContentType(ContentType.JSON).build();

      RequestSpecification deleteProdReq =  given().log().all().spec(deleteProdBaseReq).pathParam("productId",productId);
   String deleteProdutResponse= deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
            .then().log().all().extract().response().asString();

   JsonPath js2 = new JsonPath(deleteProdutResponse);
        Assert.assertEquals("Product Deleted Successfully",js2.get("message"));
    }
}
