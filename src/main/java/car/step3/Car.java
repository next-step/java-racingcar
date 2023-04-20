package car.step3;

import java.util.Objects;

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
