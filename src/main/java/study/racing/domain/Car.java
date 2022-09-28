package study.racing.domain;

import study.racing.util.RandomNameGenerator;

import java.util.Comparator;
import java.util.Objects;

public class Car implements Comparable<Car> {
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private String name;
    private Integer distance = 0;
    private MovingCondition movingCondition;

    public Car() {
     this(RandomNameGenerator.getInstance().generate(), new DefaultMovingCondition());
    }

    public Car(MovingCondition movingCondition) {
        this(RandomNameGenerator.getInstance().generate(), movingCondition);
    }

    public Car(String name) {
        this(name, new DefaultMovingCondition());
    }

    public Car(String name, MovingCondition movingCondition) {
        validateNameLength(name);
        this.name = name;
        this.movingCondition = movingCondition;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void move(int number) {
        if (movingCondition.movable(number)) {
            this.distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(movingCondition, car.movingCondition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingCondition, distance);
    }

    @Override
    public int compareTo(Car o) {
        return Comparator.comparing(Car::getDistance)
                .compare(this, o);
    }
}
