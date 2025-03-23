package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCarNames racingCarNames;
    private final NumberOfTrial numberOfTrial;
    private final List<RacingCar> racingCars;
    private final Moveable moveable;

    public RacingGame(RacingCarNames racingCarNames, NumberOfTrial numberOfTrial, Moveable moveable) {

        this.racingCarNames = racingCarNames;
        this.numberOfTrial = numberOfTrial;
        this.racingCars = initializeRacingCars();
        this.moveable = moveable;
    }

    public RacingGameResult start() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int i = 0; i < numberOfTrial.getNumberOfTrial(); i++) {
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
            racingCar.move(moveable);
        }
    }

    private List<RacingCar> initializeRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : racingCarNames.getRacingCarNames()) {
            racingCars.add(new RacingCar(name, 0));
        }
        return racingCars;
    }

    public static RacingGame of(String[] racingCarNamesArray, Integer numberOfTrialInteger, Moveable moveable) {
        RacingCarNames racingCarNames = new RacingCarNames(racingCarNamesArray);
        NumberOfTrial numberOfTrial = new NumberOfTrial(numberOfTrialInteger);
        return new RacingGame(racingCarNames, numberOfTrial, moveable);
    }
}
