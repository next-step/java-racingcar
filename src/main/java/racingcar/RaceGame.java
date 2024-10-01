package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RaceGame {
    private final List<Car> cars;
    private final int attemptCount;
    private final List<RoundResult> results = new ArrayList<>();

    public RaceGame(final int attemptCount, List<Car> cars) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void startRace() {
        for (int i = 0; i < attemptCount; i++) {
            forwardAttempt();
        }
        ResultView resultView = new ResultView();
        resultView.showGameResult(results);
    }

    private void forwardAttempt() {
        RoundResult roundResult = new RoundResult();
        for (Car car : cars) {
            int random = new Random().nextInt(10);
            car.move(random);
            roundResult.addResult(car.getPosition());
        }
        results.add(roundResult);
    }
}
