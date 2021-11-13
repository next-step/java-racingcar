package racing.model;

import java.util.*;

/*
 *
 * RacingResult
 *
 * @version 1.0.0
 *
 * 2021-11-12
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

    public List<RoundResult> getRecords() {
        return Collections.unmodifiableList(roundResults);
    }

    public String getWinner() {
        List<Car> lastRoundRecord = roundResults.get((roundResults.size() - 1)).getRecords();
        StringJoiner result = new StringJoiner(", ");
        lastRoundRecord.stream()
                .filter(x -> x.getPosition() == getTopPosition(lastRoundRecord))
                .forEach(y -> result.add(y.getName()));
        return result.toString();
    }

    private int getTopPosition(List<Car> roundRecord) {
        return roundRecord.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
