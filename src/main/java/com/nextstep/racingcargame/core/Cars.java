package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.core.RandomNumberGenerator.getRandomZeroToNine;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String HAS_NEGATIVE_CAR_CREATE_REQUEST = "1 보다 작은 수의 차량은 생성될 수 없습니다.";
    private final List<Car> cars;

    protected Cars(int numberOfCars) {
        if(!isPositive(numberOfCars)) {
            throw new IllegalArgumentException(HAS_NEGATIVE_CAR_CREATE_REQUEST);
        }
        List<Car> cars = new ArrayList<>();

        for (int index = 0; index < numberOfCars; index++) {
            cars.add(new Car());
        }
        this.cars = cars;
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

    public boolean isPositive(int number) {
        return number > 0;
    }
}
