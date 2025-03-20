package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final String[] namesOfCar;
    private final Integer numberOfTrial;
    private final List<RacingCar> racingCars;

    public RacingGame(String[] namesOfCar, Integer numberOfTrial, Moveable moveable) {
        if (isValid(namesOfCar, numberOfTrial)) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }

        this.namesOfCar = namesOfCar;
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

    private static boolean isValid(String[] namesOfCar, Integer numberOfTrial) {
        return namesOfCar.length == 0 || numberOfTrial <= 0;
    }

    private List<RacingCar> initializeRacingCars(Moveable moveable) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : namesOfCar) {
            racingCars.add(new RacingCar(name, moveable));
        }
        return racingCars;
    }
}
