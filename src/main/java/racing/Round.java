package racing;

import java.util.List;

public class Round {

    private final int roundNumber;

    public Round (int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public RoundResult play(List<Car> cars) {
        for(Car car : cars) {
            car.moveByRule();
        }
        return new RoundResult(cars);
    }

    public int getRoundNumber() {
        return roundNumber;
    }
}
