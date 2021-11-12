package racingcar;

import racingcar.dto.Winners;

import java.rmi.NoSuchObjectException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.dto.ComparableConstants.EQUAL;

public class Cars {
    private final Car CAR_AT_THE_START_POINT = new Car();

    private final List<Car> carList;
    private final RacingManager racingManager = new RacingManager();

    public Cars() {
        carList = new ArrayList<>();
    }

    public void add(Car car) {
        carList.add(car);
    }

    public boolean contains(Car car) {
        return carList.contains(car);
    }

    public Stream<Car> stream() {
        return carList.stream();
    }

    public void clear() {
        carList.clear();
    }

    public boolean sizeEqualTo(int size) {
        return carList.size() == size;
    }

    public void progressRound() {
        carList.forEach(racingManager::progressCar);
    }

    public Winners chooseWinner()  {
        Car carWithMaxDistance = getCarWithMaxDistance();

        if (carWithMaxDistance.compareTo(CAR_AT_THE_START_POINT) == EQUAL) {
            return new Winners();
        }

        return new Winners(carList.stream()
                .filter(car -> car.compareTo(carWithMaxDistance) == EQUAL)
                .map(Car::getName)
                .collect(Collectors.toList()));
    }

    private Car getCarWithMaxDistance() {
        Car carWithMaxDistance;

        try {
            carWithMaxDistance = tryGetCarWithMaxDistance();
        } catch (NoSuchObjectException excpetion) {
            return new Car();
        }

        return carWithMaxDistance;
    }

    private Car tryGetCarWithMaxDistance() throws NoSuchObjectException {
        return carList.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchObjectException("There is no max distance"));
    }
}
