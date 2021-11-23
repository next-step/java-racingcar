package racing.model;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/*
 *
 * RacingResult
 *
 * @version 1.0.0
 *
 * 2021-11-23
 *
 * Copyright tnals1422
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
        StringJoiner result = new StringJoiner(", ");
        cars.winners().forEach(car -> result.add(car.stringName()));
        return result.toString();
    }

    @Override
    public String toString() {
        return "RacingResult{" +
                "roundResults=" + roundResults +
                '}';
    }

}
