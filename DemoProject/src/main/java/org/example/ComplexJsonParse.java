package org.example;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath js=new JsonPath(payload.CoursePrice());

        int count=js.getInt("courses.size()");
        System.out.println(count);
        int totalAmount=js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);


        String titleFirstCourse=js.get("courses[2].title");
        System.out.println(titleFirstCourse);
        System.out.println("--------------------------------------------------------");
        //print all course title and their respective price
        for(int i=0;i<count;i++){
            String courseTitles=js.get("courses["+i+"].title");
            System.out.println(js.get("courses["+i+"].price").toString());
           System.out.println(courseTitles);
        }
        System.out.println("---------------------------------------------------------");

        System.out.println("Print no of copies sold by RPA course");
        for(int i=0;i<count;i++) {
            String courseTitles = js.get("courses[" + i + "].title");


            if (courseTitles.equalsIgnoreCase("RPA")) {
                int copies = js.get("courses[" + i + "].copies");
                System.out.println(copies);
                break;
            }
        }
    }
}
