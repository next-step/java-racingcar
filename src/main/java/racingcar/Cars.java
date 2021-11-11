package racingcar;

import java.rmi.NoSuchObjectException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.dto.ComparableConstants.EQUAL;

public class Cars {
    private final Car CAR_AT_THE_START_POINT = new Car();

    private final Set<Car> carSet;
    private final RacingManager racingManager = new RacingManager();

    public Cars() {
        carSet = new HashSet<>();
    }

    private Cars(Set<Car> carSet) {
        this.carSet = carSet;
    }

    public void add(Car car) {
        carSet.add(car);
    }

    public boolean contains(Car car) {
        return carSet.contains(car);
    }

    public Stream<Car> stream() {
        return carSet.stream();
    }

    public void clear() {
        carSet.clear();
    }

    public boolean sizeEqualTo(int size) {
        return carSet.size() == size;
    }

    public void progressRound() {
        carSet.forEach(racingManager::progressCar);
    }

    public Cars chooseWinner()  {
        Car carWithMaxDistance = getCarWithMaxDistance();

        if (carWithMaxDistance.compareTo(CAR_AT_THE_START_POINT) == EQUAL) {
            return new Cars();
        }

        return new Cars(carSet.stream()
                .filter(car -> car.compareTo(carWithMaxDistance) == EQUAL)
                .collect(Collectors.toSet()));
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
        return carSet.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchObjectException("There is no max distance"));
    }
}
