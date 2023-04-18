package refactoring.racingcar.domain;

import refactoring.racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(List<RacingCar> racingCars) {
        this.racingCars = new RacingCars(racingCars);
    }

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingGame setUpGame(String carNameString, MoveStrategy moveStrategy) {
        return new RacingGame(
            new RacingCars(
                Arrays.stream(carNameString.split(","))
                    .map(carName -> new RacingCar(moveStrategy, carName))
                    .collect(Collectors.toList())
            )
        );
    }

    public void play() {
        racingCars.moveAllCars();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }

    public List<RacingCar> getWinners() {
        return racingCars.getWinners();
    }
}
