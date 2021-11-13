package study03.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/*
 *
 * CarFactory
 *
 * @version 1.0.0
 *
 * 2021-11-10
 *
 * Copyright tnals1422
 */
public class Cars {

    private final List<Car> cars = new LinkedList<>();

    public Cars(int carCount) {
        IntStream.range(0, carCount)
                .forEach(i -> this.cars.add(new Car()));
    }

    public void tryMovingCarsPerRound() {
        cars.forEach(car -> car.moveOnSatisfiedCondition(Condition.generate()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}

