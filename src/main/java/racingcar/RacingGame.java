package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    public RacingGame(Cars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public List<List<Integer>> race(int roundCount) {
        List<List<Integer>> raceHistory = new ArrayList<>();

        for (int round = 0; round < roundCount; round++) {
            executeRound();

            raceHistory.add(getCurrentPositions());
        }

        return raceHistory;
    }

    private List<Integer> getCurrentPositions() {
        return cars.getDistances();
    }

    private void executeRound() {
        cars.moveAll(randomNumber);
    }
}
