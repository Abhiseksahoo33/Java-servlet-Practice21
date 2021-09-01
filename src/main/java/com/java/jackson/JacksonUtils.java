package com.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class JacksonUtils {


    private static ObjectMapper mapper = new ObjectMapper();

    //object to json
    public static String toJson(Object o)
    {

        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //json to object
    public static <T> T toObject(String json, Class<T> t)
    {
        try {
            return mapper.readValue(json,t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //json to object
    public static <T> T toObject(InputStream json, Class<T> t)
    {
        try {
            return mapper.readValue(json,t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Employee e= new Employee();
        e.setAge(20);
        e.setName("Abhisek");
        e.setUuid(UUID.randomUUID().toString());


        System.out.println(e);      //Employee{uuid='602924a6-ab5d-48be-9aae-9d1f1044f716', name='Abhisek', age=20}
    //object to stream of bytes (seriallization)
    // stream of bytes to object(deseriallization)

        String valuestr=toJson(e);
        System.out.println(e.hashCode());  //159259014
        System.out.println(valuestr);      //{"uuid":"6c4a0b43-0da8-493a-b949-f7a5c388604c","name":"Abhisek","age":20}
        e=toObject(valuestr,Employee.class);
        System.out.println(e.hashCode());  //650023597 (different hashcode )
        System.out.println(e);             //Employee{uuid='9fd5cbee-98fe-450f-ae91-305a5bfb23e6', name='Abhisek', age=20}

    InputStream is=JacksonUtils.class.getClassLoader().getResourceAsStream("data.json");
        System.out.println(is);             //java.io.BufferedInputStream@4c70fda8
        e=toObject(is,Employee.class);
        System.out.println(e.hashCode());   //695682681 (different hashcode )
        System.out.println(e);              //Employee{uuid='9fd5cbee-98fe-450f-ae91-305a5bfb23e6', name='Abhisek', age=20}





    }
}
