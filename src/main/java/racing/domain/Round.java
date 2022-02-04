package racing.domain;

import java.util.List;

public class Round {

    private final int roundNumber;

    public Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public RoundResult play(List<Car> cars) {
        for (Car car : cars) {
            car.moveByRule(MoveRule.makeValue());
        }
        return new RoundResult(cars);
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
