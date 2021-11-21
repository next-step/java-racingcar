package racing.model;

import java.util.LinkedList;
import java.util.List;

/**
 * .
 */
public class RacingResult {

    private final List<RoundResult> roundResults;

    public RacingResult() {
        roundResults = new LinkedList<>();
    }

    public void add(RoundResult roundResult) {
        roundResults.add(roundResult);
    }

    public List<RoundResult> records() {
        return roundResults;
    }

    public String winner() {
        Cars cars = new Cars(roundResults.get(roundResults.size() - 1).records());
        return cars.winners();
    }

    @Override
    public String toString() {
        return "RacingResult{" +
                "roundResults=" + roundResults +
                '}';
    }

}
