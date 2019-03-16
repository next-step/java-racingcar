package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Race {
    private List<RacingCar> cars;

    public Race(final String... carNames) {
        this.cars = new ArrayList<>();
        this.initRacingCars(carNames);
    }

    public Race(final List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private void initRacingCars(final String... carNames) {
        Arrays.asList(carNames)
                .forEach(carName -> this.cars.add(new RacingCar(carName)));
    }

    public List<RacingCar> play() {
        for (RacingCar car : this.cars) {
            car.moveRandomly();
        }

        return this.cars;
    }

    public List<RacingCar> getWinners() {
        return getWinners(getMaxPosition());
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (RacingCar car : this.cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<RacingCar> getWinners(final int maxPosition) {
        return this.cars.stream()
                .filter(car -> car.hasMaxPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
