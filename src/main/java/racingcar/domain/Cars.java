package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final int INITIAL_LOCATION = 1;
    private static final int DEFAULT_VALUE = 0;
    private final List<Car> participants = new ArrayList<>();

    public Cars(String[] carNameArr) {
        Arrays.stream(carNameArr).map(carName -> new Car(carName, INITIAL_LOCATION))
                .forEachOrdered(participants::add);
    }

    public List<Car> getCars() {
        return participants;
    }

    public void move() {
        participants.forEach(car -> car.move(new RandomGenerator()));
    }

    public int getMaxLocation() {
        return this.participants.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(DEFAULT_VALUE);
    }

    public String getWinnerCarNames() {
        return this.participants.stream()
                .filter(car -> car.getLocation() == getMaxLocation())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
