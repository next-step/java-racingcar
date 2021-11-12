package carracingwinner.domain;

import java.util.ArrayList;
import java.util.List;

public class Rounds {

    private final List<Result> results = new ArrayList<>();

    private int roundCount;

    public Rounds(int tryCount) {
        this.roundCount = tryCount;
    }

    public void playRounds(Cars cars) {
        while (roundCount-- > 0) {
            playOneRound(cars);
        }
    }

    private void playOneRound(Cars cars) {
        Result result = cars.move();
        results.add(result);
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getLastWinners() {
        return results.get(results.size() - 1).getWinners();
    }

}
