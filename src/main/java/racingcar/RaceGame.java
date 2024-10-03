package racingcar;

import java.util.ArrayList;
import java.util.List;

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
    }

    public List<RoundResult> getResults() {
        return results;
    }

    public void showGameResult() {
        ResultView.printResultView(results);
    }

    private void forwardAttempt() {
        RoundResult roundResult = new RoundResult();
        for (Car car : cars) {
            car.move();
            roundResult.addResult(car.getPosition());
        }
        results.add(roundResult);
    }
}
