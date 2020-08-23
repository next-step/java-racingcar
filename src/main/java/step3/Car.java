package step3;

import java.util.ArrayList;

public class Car {

    private String name;
    private int currentPosition;

    Car(){}

    Car(String name){
        if(name.length() > 5) throw new IllegalArgumentException();
        this.name = name;
    }

    public int moveForward(boolean success){
        if(success){
            currentPosition++;
        }
        return currentPosition;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public String getName(){
        return this.name;
    }

}