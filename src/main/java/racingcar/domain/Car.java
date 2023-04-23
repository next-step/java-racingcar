package racingcar.domain;


import java.util.*;

public class Car {
    private Position position;
    private String name;
    private static int START = 0;
    private final int NAME_STANDARD = 5;

    public Car(String name) {
        this(name, START);
    }

    public Car(String name, int position) {
        this.name = validateName(name);
        this.position = new Position(position);
    }

    private String validateName(String carName) {
        if (carName.length() > NAME_STANDARD) {
            throw new IllegalArgumentException("over 5 length");
        }
        return carName;
    }

    public Position drive()
    {
        position = position.move();
        return position;
    }

    public int getDistance()
    {
        return position.getPosition();
    }

    public String getName() {
        return name;
    }

    public int compare(int otherPosition) {
        return position.comparePosition(otherPosition);
    }

    public boolean isSamePosition(int maxPosition) {
        return position.equalPosition(maxPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }
}
