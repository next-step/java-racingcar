package domain;

import movingStrategy.Moveable;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Integer numberOfCar;
    private final Integer numberOfTrial;
    private final List<RacingCar> racingCars;

    public RacingGame(Integer numberOfCar, Integer numberOfTrial, Moveable moveable) {
        if (isValid(numberOfCar, numberOfTrial)) {
            throw new IllegalArgumentException("자동차의 수 또는 시도 횟수는 0보다 커야 합니다.");
        }

        this.numberOfCar = numberOfCar;
        this.numberOfTrial = numberOfTrial;
        this.racingCars = initializeRacingCars(moveable);
    }

    public RacingGameResult gameStart() {
        RacingGameResult racingGameResult = new RacingGameResult();
        for (int i = 0; i < numberOfTrial; i++) {
            moveCars();
            racingGameResult.addRoundResult(new RoundResult(racingCars));
        }
        return racingGameResult;
    }

    private void moveCars() {
        for (RacingCar racingCar : racingCars) {
            racingCar.move();
        }
    }

    private static boolean isValid(Integer numberOfCar, Integer numberOfTrial) {
        return numberOfCar <= 0 || numberOfTrial <= 0;
    }

    private List<RacingCar> initializeRacingCars(Moveable moveable) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            racingCars.add(new RacingCar(moveable));
        }
        return racingCars;
    }
}
