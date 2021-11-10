package edu.nextstep.camp;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static final int NAME_LIMIT = 5;
    private static final int MINIMUM_NUMBER_OF_CAR = 1;

    private final String name;
    private final Position position;
    private final MovePolicy movePolicy;

    private Car(String name, MovePolicy movePolicy) {
        this.name = name;
        this.position = Position.ofZero();
        this.movePolicy = movePolicy;
    }

    public static List<Car> of(String[] names, MovePolicy movePolicy) {
        if (names == null) {
            throw new IllegalArgumentException("Name of cars cannot be null.");
        }

        if (names.length < MINIMUM_NUMBER_OF_CAR) {
            throw new IllegalArgumentException("invalid number of cars: " + names.length);
        }

        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(Car.of(name, movePolicy));
        }

        return cars;
    }

    public static Car of(String name, MovePolicy movePolicy) {
        if (name == null || name.isEmpty() || name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("invalid name: " + name);
        }

        if (movePolicy == null) {
            throw new IllegalArgumentException("move policy cannot be null.");
        }

        return new Car(name, movePolicy);

    }

    public Position position() {
        return position;
    }

    public void attemptToMove() {
        if (movePolicy.needToMove()) {
            position.forward();
        }
    }

    public String name() {
        return name;
    }
}
