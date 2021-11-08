package racingcar.collection;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private Winners winners;
    private final List<Race> histories = new ArrayList<>();

    public void addRaceResult(Race result) {
        histories.add(result);
    }

    public List<Race> getHistories() {
        return histories;
    }

    public void setWinners(Winners winners) {
        this.winners = winners;
    }

    public Winners getWinners() {
        return winners;
    }
}
