package study;

import java.util.Random;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        new Car(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        if(new Random().nextInt(10) > 4) {
            position++;
        }
    }

    public void print() {
        for (int i = 0; i <position ; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
            "name='" + name + '\'' +
            ", position=" + position +
            '}';
    }
}
