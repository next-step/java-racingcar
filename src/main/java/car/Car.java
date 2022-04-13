package car;

import java.util.Random;

public class Car {
    public static final int EXCESS_NUMBERS = 4;
    private String name;
    private StringBuilder distance;

    public Car(String name) {
        this.distance = new StringBuilder();
        this.name = name;
    }

    public String move(int number) {
        if (number < EXCESS_NUMBERS) {
            return "";
        }

        this.distance.append("-");
        return this.distance.toString();
    }

    public void print() {

    }
}
