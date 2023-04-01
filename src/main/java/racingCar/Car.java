package racingCar;

import java.util.Random;

public class Car implements Comparable<Car> {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int INITIAL_LOCATION = 0;
    private static final int CHECK_MAX_RANDOM_NUMBER = 10;
    private static final int MOVABLE_MIN_NUMBER = 4;

    private final String name;
    private int location;

    public Car(String name) {
        this(name, INITIAL_LOCATION);
    }

    public Car(String name, int location) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name;
        this.location = location;
    }

    public void move(Random random) {
        if (random.nextInt(CHECK_MAX_RANDOM_NUMBER) >= MOVABLE_MIN_NUMBER) {
            location++;
        }
    }

    public void print() {
        String stringBuilder = name + " : " + "-".repeat(Math.max(INITIAL_LOCATION, location));
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