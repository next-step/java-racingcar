package car.step3;

import java.util.Objects;
import java.util.Random;

public class Car {
    private String name;
    private int location = 0;
    private int MAX_BOUNCE = 10;
    private int FORWARD_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void go() {
        if(getRandomNumber() >= FORWARD_NUMBER) {
            this.location++;
        }
    }

    public int location() {
        return location;
    }

    public String name(){
        return name;
    }

    protected int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUNCE);
    }
}
