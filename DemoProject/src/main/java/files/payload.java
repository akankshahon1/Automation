package files;

public class payload {


        public static String AddPlace()

        {
            return "{\r\n" +
                    "  \"location\": {\r\n" +
                    "    \"lat\": -38.383494,\r\n" +
                    "    \"lng\": 33.427362\r\n" +
                    "  },\r\n" +
                    "  \"accuracy\": 50,\r\n" +
                    "  \"name\": \"Rahul Shetty Academy\",\r\n" +
                    "  \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
                    "  \"address\": \"29, side layout, cohen 09\",\r\n" +
                    "  \"types\": [\r\n" +
                    "    \"shoe park\",\r\n" +
                    "    \"shop\"\r\n" +
                    "  ],\r\n" +
                    "  \"website\": \"http://rahulshettyacademy.com\",\r\n" +
                    "  \"language\": \"French-IN\"\r\n" +
                    "}\r\n" +
                    "";


        }
    public static String CoursePrice(){

            return "{\n" +
                    "\n" +
                    "\"dashboard\": {\n" +
                    "\n" +
                    "\"purchaseAmount\": 1162,\n" +
                    "\n" +
                    "\"website\": \"rahulshettyacademy.com\"\n" +
                    "\n" +
                    "},\n" +
                    "\n" +
                    "\"courses\": [\n" +
                    "\n" +
                    "{\n" +
                    "\n" +
                    "\"title\": \"Selenium Python\",\n" +
                    "\n" +
                    "\"price\": 50,\n" +
                    "\n" +
                    "\"copies\": 6\n" +
                    "\n" +
                    "},\n" +
                    "\n" +
                    "{\n" +
                    "\n" +
                    "\"title\": \"Cypress\",\n" +
                    "\n" +
                    "\"price\": 40,\n" +
                    "\n" +
                    "\"copies\": 4\n" +
                    "\n" +
                    "},\n" +
                    "\n" +
                    "{\n" +
                    "\n" +
                    "\"title\": \"RPA\",\n" +
                    "\n" +
                    "\"price\": 45,\n" +
                    "\n" +
                    "\"copies\": 10\n" +
                    "\n" +
                    "},\n" +
                    "  {\n" +
                    "\n" +
                    "\"title\": \"appium\",\n" +
                    "\n" +
                    "\"price\": 36,\n" +
                    "\n" +
                    "\"copies\": 7\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "]\n" +
                    "\n" +
                    "}\n" +
                    "\n";


    }
    public static String Addbook(String isbn,String aisle ){
       String payload= "{\r\n" +
        "\r\n" +
        "\"name\":\"Learn Appium Automation with Java\",\n" +
        "\"isbn\":\""+isbn+"\",\r\n" +
        "\"aisle\":\""+aisle+"\",\r\n\"author\":\"John foe\"\n" +
        "}\r\n" +
        " \r\n"+
                "";
       return payload;
    }


}


