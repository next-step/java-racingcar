package car.step3;

import java.util.Objects;
import java.util.Random;

public class Car {
    private String name;
    private int location = 0;


    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void go(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            this.location++;
        }
    }

    public int location() {
        return location;
    }

    public String name(){
        return name;
    }

}
