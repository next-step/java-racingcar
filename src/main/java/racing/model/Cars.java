package racing.model;

import java.util.Arrays;
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
 * 2021-11-12
 *
 * Copyright tnals1422
 */
public class Cars {

    private final List<Car> cars = new LinkedList<>();

    public Cars(String carNames) {
        Arrays.stream(carNames.split(","))
                .forEach(carName -> this.cars.add(new Car(carName)));
    }

    public void tryMovingCarsPerRound() {
        cars.forEach(car -> car.moveOnSatisfiedCondition(Condition.generate()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}


