package com.subhra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component//SprinContainer will manage the bean of Greet class
public class Greet {
    private Greeting greeting;

    public Greet(){
        System.out.println("Greet object is constructed");
    }
    @Autowired
    public void setGreeting(Greeting greeting){
        System.out.println("Greeting object is injected");
        this.greeting = greeting;
    }
    
    @PostConstruct//after DI
    public void init(){
        System.out.println("Bean is initialized");
    }

    @PreDestroy//previous phase of destruction of bean
    public void destroy(){
        System.out.println("Greet bean is destroyed");
    }
    public void Greet(){
        System.out.println("Hello Everyone");
       // greeting.sayHii();
    }
}
