package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class RacingGame {

    private final int time;
    private final Cars cars;

    public RacingGame(int time, int numberOfCars) {
        this.time = time;
        this.cars = new Cars(numberOfCars);
    }

    public RacingGameResults game() {
        Map<Integer, Cars> racingGameHistory = new HashMap<>();
        for (int i = 0; i < time; i++) {
            Cars value = cars.moveAllCar(new DefaultMoveStrategy());
            racingGameHistory.put(i, value);
        }
        return new RacingGameResults(racingGameHistory);
    }

}
