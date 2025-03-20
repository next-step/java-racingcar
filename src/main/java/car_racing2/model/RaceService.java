package car_racing2.model;

import car_racing2.view.InputData;

import java.util.Random;
import java.util.function.BooleanSupplier;

public class RaceService {
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;

    public RaceResult race(InputData raceData) {
        Cars cars = new Cars(raceData.getCarNames(), randomMovingStrategy());
        RaceResult raceResult = new RaceResult();

        for (int i = 0; i < raceData.getNumOfRounds(); i++) {
            cars.moveAll();
            raceResult.recordResultOfRound(cars.getPositionsOfCars());
        }
        raceResult.recordRaceWinners(cars.getWinners());

        return raceResult;
    }

    private BooleanSupplier randomMovingStrategy() {
        return () -> random.nextInt() > MOVE_THRESHOLD;
    }
}
