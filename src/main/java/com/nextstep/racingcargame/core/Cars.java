package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.core.RandomNumberGenerator.getRandomZeroToNine;
import static java.util.Arrays.stream;
import static java.util.Collections.max;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String HAS_NEGATIVE_CAR_CREATE_REQUEST = "1 보다 작은 수의 차량은 생성될 수 없습니다.";

    private static final String WINNER_JOIN_DELIMITER = ",";
    private final List<Car> cars;

    // root ctor
    public Cars(List<Car> cars) {
        if (!isMoreThanOneCar(cars.size())) {
            throw new IllegalArgumentException(HAS_NEGATIVE_CAR_CREATE_REQUEST);
        }
        this.cars = cars;
    }

    public Cars(CarNameChunk carNameChunk) {
        this(stream(carNameChunk.carNames())
                .map(Car::new)
                .collect(Collectors.toList()));
    }

    public int carSize() {
        return cars.size();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveForwardByNumber(getRandomZeroToNine());
        }
    }

    public void disPlayCarsTravelDistance() {
        for (int carIndex = 0; carIndex < carSize(); carIndex++) {
            cars.get(carIndex).printTravelDistanceWithCarName();
        }
    }

    public boolean isMoreThanOneCar(int number) {
        return number > 0;
    }

    public List<String> winnerNames() {
        return this.cars.stream()
                .filter(car -> car.getDistance() == getFurthestDistance())
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public String joinedWinnerNames() {
        return String.join(WINNER_JOIN_DELIMITER, winnerNames());
    }

    public Car findFirstFurthestTraveledCar() {
        return max(this.cars, Comparator.comparingInt(Car::getDistance));
    }

    public int getFurthestDistance() {
        return findFirstFurthestTraveledCar().getDistance();
    }
}
