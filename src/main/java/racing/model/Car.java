package racing.model;

import java.util.Optional;
import java.util.function.Predicate;

/*
 *
 * Car
 *
 * @version 1.0.0
 *
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class Car {

    private static final int CRITERIA = 4;
    private final String name;
    private int position;

    public Car(String carName) {
        this.name = carName;
        this.position = 0;
    }

    public Car(String carName, int position) {
        this.name = carName;
        this.position = position;
    }

    public void moveOnSatisfiedCondition(int condition) {
        Optional.of(condition)
                .filter(isForward())
                .ifPresent(x -> position++);
    }

    private Predicate<Integer> isForward() {
        return number -> number >= CRITERIA;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
