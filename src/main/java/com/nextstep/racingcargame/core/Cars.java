package com.nextstep.racingcargame.core;

import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

    private final List<Car> cars;
    private static final String HAS_NEGATIVE_CAR_CREATE_REQUEST = "1 보다 작은 수의 차량은 생성될 수 없습니다.";
    private static final int START_POSITION = 0;

    // root ctor
    public Cars(List<Car> cars) {
        if (!isMoreThanOneCar(cars)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_CAR_CREATE_REQUEST);
        }
        this.cars = cars;
    }

    public Stream<Car> carStream() {
        return this.cars.stream();
    }

    public Cars(CarNameChunk carNameChunk) {
        this(stream(carNameChunk.carNames())
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public int carSize() {
        return cars.size();
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (int index = 0; index < carSize(); index++) {
            this.cars.set(index, this.cars.get(index).move(movingStrategy));
        }
    }

    private boolean isMoreThanOneCar(List<Car> cars) {
        return !cars.isEmpty();
    }

    public List<String> winnerNames() {
        return this.cars.stream()
                .filter(car -> car.sameDistance(longestDistance()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public String joinedWinnerNames(String joinDelimiter) {
        return String.join(joinDelimiter, winnerNames());
    }

    public Distance longestDistance() {
        Distance maxDistance = new Distance(START_POSITION);

        for (Car car : this.cars) {
            maxDistance = updateMaxDistance(car, maxDistance);
        }
        return maxDistance;
    }

    private Distance updateMaxDistance(Car car, Distance maxDistance) {
        if (car.isLongerThan(maxDistance)) {
            return car.getDistance();
        }
        return maxDistance;
    }

}
