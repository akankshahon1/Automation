package org.example;

import java.io.IOException;
import java.util.ArrayList;

public class testSample {
    public static void main(String[] args) throws IOException {
        dataDriven d=new dataDriven();
     ArrayList data= d.getdata("Add Profile");
     System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
       // driver.findElement(by.xpath("fdee")).sendKeys(data.get(1));
    }
}
