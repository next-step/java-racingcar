package domain.game;

import java.util.ArrayList;
import java.util.List;

import domain.cars.MovingStrategy;
import domain.cars.RacingCars;

public class RacingResult {
    private List<String[]> racingResult;

    public RacingResult(int round, RacingCars racingCars, MovingStrategy movingStrategy) {
        this.racingResult = new ArrayList<>();
        for (int i = 0; i < round; i++) {
            racingCars.race(movingStrategy);
            racingResult.add(racingCars.getResultOfEachCar());
        }
    }

    public List<String[]> getRacingResult() {
        return racingResult;
    }
}
