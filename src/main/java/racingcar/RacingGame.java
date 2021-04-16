package racingcar;

import racingcar.domains.*;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public RacingCars initiateCars(String carNames) {
        List<RacingCar> racingCars = new ArrayList<>();

        String[] cars = carNames.split(",");

        for (int i = 0; i < cars.length; i++) {
            racingCars.add(new RacingCar(cars[i]));
        }

        return new RacingCars(racingCars);
    }

    public RacingResultsAll startRace(RacingCars racingCars, int roundNumTotal) {
        List<RacingResultsPerRound> racingResultAllRounds = new ArrayList<>();

        for (int i = 0; i < roundNumTotal; i++) {
            RacingResultsPerRound resultPerRound = racePerRound(racingCars);
            racingResultAllRounds.add(resultPerRound);
        }

        return new RacingResultsAll(racingResultAllRounds);
    }

    private RacingResultsPerRound racePerRound(RacingCars racingCars) {
        List<RacingResultForEachCar> racingResultForEachCars = new ArrayList<>();

        for (int j = 0; j < racingCars.size(); j++) {
            int currentPosition = racingCars.move(j);
            RacingResultForEachCar racingResultForEachCar = new RacingResultForEachCar(racingCars.getCarName(j), currentPosition);
            racingResultForEachCars.add(racingResultForEachCar);
        }

        return new RacingResultsPerRound(racingResultForEachCars);
    }

}
