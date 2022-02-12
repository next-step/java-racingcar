package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    private final List<Car> cars;
    private final Round round;

    public Racing(List<Car> cars, int totalRoundNumber) {
        this.round = new Round(totalRoundNumber);
        this.cars = cars;
    }

    public void race() {
        round.playTotalRound(cars);
    }

    public RoundResults getResults() {
        return round.getRoundResults();
    }
}
