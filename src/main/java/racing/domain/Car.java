package racing.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;

    private int position;
    private final String name;

    private Random random = new Random();

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void run(int random) {
        if (checkMove(random)) {
            move();
        }
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

    private void move() {
        this.position++;
    }

    private boolean checkMove(int randomNumber) {
        return randomNumber >= MIN_NUMBER;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name) &&
                Objects.equals(random, car.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name, random);
    }
}
