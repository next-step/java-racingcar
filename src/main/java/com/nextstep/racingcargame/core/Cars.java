package com.nextstep.racingcargame.core;

import static com.nextstep.racingcargame.core.RandomNumberGenerator.getRandomZeroToNine;
import static java.util.Arrays.stream;

import java.util.List;
import java.util.stream.Collectors;

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


    private boolean isMoreThanOneCar(List<Car> cars) {
        return !cars.isEmpty();
    }

    public List<String> winnerNames() {
        return this.cars.stream()
                .filter(car -> car.getDistance().equals(longestDistance()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public String joinedWinnerNames(String joinDelimiter) {
        return String.join(joinDelimiter, winnerNames());
    }

    public Distance longestDistance() {
        Distance maxDistance = new Distance(START_POSITION);

        for(Car car : this.cars) {
            maxDistance = updateMaxDistance(car,maxDistance);
        }
        return maxDistance;
    }

    private Distance updateMaxDistance(Car car, Distance maxDistance) {
        if(car.isLongerThan(maxDistance)) {
            return car.getDistance();
        }
        return maxDistance;
    }

    public List<String> getAllCarCurrentDistance(String separator, String distancePrintStandard) {
        return this.cars.stream()
                .map(car -> car.getDistanceAsPrintForm(separator,distancePrintStandard))
                .collect(Collectors.toList());
    }

}
