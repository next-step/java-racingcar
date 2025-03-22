package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCarNames racingCarNames;
    private final Integer numberOfTrial;
    private final List<RacingCar> racingCars;

    public RacingGame(RacingCarNames racingCarNames, Integer numberOfTrial, Moveable moveable) {

        this.racingCarNames = racingCarNames;
        this.numberOfTrial = numberOfTrial;
        this.racingCars = initializeRacingCars(moveable);
    }

    public RacingGameResult gameStart() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int i = 0; i < numberOfTrial; i++) {
            progressRound(racingGameResult);
        }
        return racingGameResult;
    }

    private void progressRound(RacingGameResult racingGameResult) {
        moveCars();
        racingGameResult.addRoundResult(new RoundResult(racingCars));
    }

    private void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    private List<RacingCar> initializeRacingCars(Moveable moveable) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames.getRacingCarNames()) {
            racingCars.add(new RacingCar(name, moveable));
        }
        return racingCars;
    }

    public static RacingGame of(String[] racingCarNamesArray, Integer numberOfTrial, Moveable moveable) {
        RacingCarNames racingCarNames = new RacingCarNames(racingCarNamesArray);
        return new RacingGame(racingCarNames, numberOfTrial, moveable);
    }
}
