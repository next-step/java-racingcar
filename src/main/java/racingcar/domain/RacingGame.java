package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> racingCars;

    public RacingGame(String... carNames) {
        this.racingCars = new ArrayList<>();
        this.initRacingCars(carNames);
    }

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    private void initRacingCars(String... carNames) {
        Arrays.asList(carNames)
                .forEach(carName -> this.racingCars.add(new RacingCar(carName)));
    }

    public List<RacingCar> play() {
        for (RacingCar car : this.racingCars) {
            car.moveRandomly();
        }

        return this.racingCars;
    }

    public List<RacingCar> getWinners() {
        return getWinners(getMaxPosition());
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (RacingCar car : this.racingCars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }

        return maxPosition;
    }

    private List<RacingCar> getWinners(final int maxPosition) {
        return this.racingCars.stream()
                .filter(car -> car.hasMaxPosition(maxPosition))
                .collect(Collectors.toList());
    }
}
