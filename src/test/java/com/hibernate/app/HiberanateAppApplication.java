package com.hibernate.app;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HiberanateAppApplication {

    public static void main(String[] args) throws JSONException {
//        String json_data = "{\"student\":{\"name\":\"Neeraj Mishra\", \"age\":\"22\"}}";
//        JSONObject obj = new JSONObject(json_data);
//        //converting json to xml
//        String xml_data = XML.toString(obj);
//        System.out.println(xml_data);
        SpringApplication.run(HiberanateAppApplication.class, args);
    }

}
