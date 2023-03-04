package racing;

import java.util.Comparator;
import java.util.Random;

public class Car implements Comparable<Car> {
    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int location) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name;
        this.location = location;
    }

    private final String name;
    private int location;

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
            location++;
        }
    }

    public void print() {
        String stringBuilder = name + " : " + "-".repeat(Math.max(0, location));
        System.out.println(stringBuilder);
    }

    public boolean isEqualLocation(Car car) {
        return car.location == this.location;
    }


    @Override
    public int compareTo(Car c) {
        return this.location - c.location;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
