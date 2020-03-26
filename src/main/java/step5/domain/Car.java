package step5.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int RANDOM_RANGE = 10;

    private Random random = new Random();
    private final String name;
    private Position position;

    public Car(final String name, String position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move() {
        position = position.move(createRandomNumber());
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position.getPosition();
    }

    private int createRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }

    public boolean isSame(String maxRacingResult) {
        if (position.getPosition().equals(maxRacingResult)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        final Car car = (Car) o;
        return
                Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
