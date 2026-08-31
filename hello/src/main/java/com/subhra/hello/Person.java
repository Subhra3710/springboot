package com.subhra.hello;

import org.springframework.stereotype.Component;

@Component              //Stereotype Annotation
public class Person {
    public void sayHello(){
        System.out.println("Person says hello ");
    } 
}
