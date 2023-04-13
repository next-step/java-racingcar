package racingcar;

import racingcar.strategy.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCarGame {
    private final List<RacingCar> racingCars;
    private final PrintStrategy printStrategy;

    public RacingCarGame(
        List<RacingCar> racingCars,
        PrintStrategy printStrategy
    ) {
        this.racingCars = racingCars;
        this.printStrategy = printStrategy;
    }

    public static RacingCarGame setUpGame(String[] carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        MoveStrategy moveStrategy = new RandomMoveStrategy(new DefaultRandomStrategy(), 4);
        for (int i = 0; i < carNames.length; i++) {
            racingCars.add(new RacingCar(carNames[i], moveStrategy));
        }
        PrintStrategy printStrategy = new PositionPrintStrategy();
        return new RacingCarGame(racingCars, printStrategy);
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.goOrStop();
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public void printPosition() {
        printStrategy.print(racingCars);
    }

    public List<RacingCar> getWinners() {
        RacingCar maxPositionRacingCar = racingCars.get(0);
        List<RacingCar> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.compareTo(maxPositionRacingCar) == 1) {
                maxPositionRacingCar = racingCar;
                winners.clear();
                winners.add(racingCar);
            } else if (racingCar.compareTo(maxPositionRacingCar) == 0) {
                winners.add(racingCar);
            }
        }
        return winners;
    }
}
