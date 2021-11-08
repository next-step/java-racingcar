package racingcar.collection;


import java.util.ArrayList;
import java.util.List;

public class RaceHistories {
    private final List<RaceResult> histories = new ArrayList<>();

    public void addRaceResult(RaceResult result) {
        histories.add(result);
    }

    public List<RaceResult> getHistories() {
        return histories;
    }
}
