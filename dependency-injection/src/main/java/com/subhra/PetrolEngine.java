package com.subhra;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{

    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol started");
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol stopped");
    }
    
}
