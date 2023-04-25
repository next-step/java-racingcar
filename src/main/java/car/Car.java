package car;

import java.util.Random;

public class Car {

    private int position = 0;
    private String name;

    private Car(){}
    public Car(String name){
        carNameCheck(name);
        this.name = name;
    }
    public void move(int moveStrategy){
        if(moveStrategy > 3) {
            position += 1;
        }
    }
    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    public String carNameCheck(String name){
        if(name.length() > 5){
            throw new RuntimeException();
        }
        return name;
    }
}
