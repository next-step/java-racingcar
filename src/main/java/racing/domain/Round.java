package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private int totalRoundNumber;
    private final RoundResults roundResults;

    public Round(int totalRoundNumber) {
        this.totalRoundNumber = totalRoundNumber;
        this.roundResults = new RoundResults();
    }

    public void playTotalRound(List<Car> cars) {
        while(inProgress()) {
            play(cars);
            totalRoundNumber--;
        }
    }

    private void play(List<Car> cars) {
        List<CarResult> results = new ArrayList<>();

        for (Car car : cars) {
            car.move();
            results.add(new CarResult(car.getName(), car.getDistance()));
        }

        roundResults.save(results);
    }

    private boolean inProgress() {
        return totalRoundNumber > 0;
    }

    public RoundResults getRoundResults() {
        return roundResults;
    }
}
