package racing.model;

import java.util.*;
import java.util.stream.Collectors;
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

    private final List<Car> cars;

    public Cars(String carNames) {
        this(
                Arrays.stream(carNames.split(","))
                        .map(Car::new)
                        .collect(Collectors.toList())
        );
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryMovingCarsPerRound() {
        cars.forEach(car -> car.moveOnSatisfiedCondition(Condition.generate()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinner() {
        StringJoiner result = new StringJoiner(", ");
        cars.stream()
                .filter(x -> x.getPosition() == getTopPosition(cars))
                .forEach(y -> result.add(y.getName()));
        return result.toString();
    }

    private int getTopPosition(List<Car> roundRecord) {
        return roundRecord.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}


