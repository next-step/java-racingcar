package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResults {

    private final List<List<CarResult>> roundResults = new ArrayList<>();

    public void save(List<CarResult> roundResult) {
        roundResults.add(roundResult);
    }

    public List<List<CarResult>> getRawResults() {
        return new ArrayList<>(roundResults);
    }

    public List<CarResult> getLastRawResult() {
        final int lastIndex = roundResults.size() - 1;
        return new ArrayList<>(roundResults.get(lastIndex));
    }
}
