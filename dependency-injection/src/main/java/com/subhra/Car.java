package com.subhra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    //private Engine engine = new Engine();

    //DI(Dependency Injection)-mechanism in which SpringContainer automnatically inject the bean inside a class reference variable
    //in simple word SpringContainer automatically assigns the address of the beans inside another class reference variable
    //1.Field based injection-NR
   // @Autowired//can work with all three injections// if not exception
    //private Engine engine;
    //2.Setter method based injection-R
    //private Engine engine;
    //@Autowired
    //public void setEngine(Engine engine){
        //System.out.println("parameter engine"+engine);
        //System.out.println("variable engine"+this.engine);
        //this.engine = engine;
    //}
    //3.Constructor based injection-HR
    private Engine engine;
    @Autowired
    public Car (Engine engine){
        this.engine = engine;
        System.out.println("Parameterized constructor");
    }
    public Car(){
        System.out.println("Non-Parameterized constructor");
    }
    public void startCar(){
        //Engine engine = new Engine();
        engine.startEngine();
        System.out.println("Car is started");
    }
    public void stopCar(){
       // Engine engine= new Engine();
        engine.stopEngine();
        System.out.println("Car is stopped");
    }
}
