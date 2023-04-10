package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.core.RandomNumberGenerator.getRandomZeroToNine;
import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String HAS_NEGATIVE_CAR_CREATE_REQUEST = "1 보다 작은 수의 차량은 생성될 수 없습니다.";
    private final List<Car> cars;

    // root constructor
    public Cars(List<Car> cars) {
        if(!isMoreThanOneCar(cars.size())) {
            throw new IllegalArgumentException(HAS_NEGATIVE_CAR_CREATE_REQUEST);
        }
        this.cars = cars;
    }

    Cars(CarNameChunk carNameChunk) {
        this(stream(carNameChunk.carNames()).map(Car::new)
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
            cars.get(carIndex).printTravelDistance();
        }
    }

    public boolean isMoreThanOneCar(int number) {
        return number > 0;
    }
}
