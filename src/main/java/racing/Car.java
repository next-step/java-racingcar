package racing;

import java.util.Comparator;
import java.util.Random;

public class Car implements Comparator<Car> {
    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name;
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
    public int compare(Car c1, Car c2) {
        return c1.location - c2.location;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
