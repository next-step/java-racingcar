package racinggame.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;

    private final Name name;
    private Position position = new Position();

    public Car(final String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(new Name(name), position);
    }

    public Car(Name name, int position) {
        this(name, new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public int getPosition() {
        return position.value();
    }

    public String getName() {
        return name.getName();
    }

    public void move() {
        Random random = new Random();
        int randomNo = random.nextInt(MAX_BOUND);
        if (randomNo >= FORWARD_NUM)
            this.position.increase();
    }

    public RaceResult result() {
        return new RaceResult(this.name.getName(), this.position.value());
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isMaxPosition(maxPosition);
    }

    public int max(int maxPosition) {
        return this.position.max(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
