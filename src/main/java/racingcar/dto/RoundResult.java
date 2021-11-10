package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private final List<String> results = new ArrayList<>();

    public List<String> getResults() {
        return results;
    }

    public void record(String result) {
        results.add(result);
    }
}
