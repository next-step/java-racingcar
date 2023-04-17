package car.step3;

import java.util.Objects;

public class Car {
    private int location = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        this.location++;
    }

    public int location() {
        return location;
    }

    public String name(){
        return name;
    }
}
