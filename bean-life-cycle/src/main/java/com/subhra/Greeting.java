package com.subhra;

import org.springframework.stereotype.Component;

@Component
public class Greeting {
    public Greeting(){
        System.out.println("Greeting object is created");
    }
    
    public void sayHii(){
        System.out.println("HIIIIIIIIIIIII");
    }
}
