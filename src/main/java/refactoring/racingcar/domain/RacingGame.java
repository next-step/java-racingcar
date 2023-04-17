package refactoring.racingcar.domain;

import refactoring.racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<RacingCar> racingCars;

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingGame setUpGame(String carNameString, MoveStrategy moveStrategy) {
        return new RacingGame(
            Arrays.stream(carNameString.split(","))
                .map(carName -> new RacingCar(moveStrategy, carName))
                .collect(Collectors.toList())
        );
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<RacingCar> getWinners() {
        Position maxPosition = new Position(0);
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition().compareTo(maxPosition) > 0) {
                maxPosition = racingCar.getPosition();
            }
        }

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition().compareTo(maxPosition) == 0) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
