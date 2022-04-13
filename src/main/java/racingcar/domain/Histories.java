package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Histories {

    private final List<History> histories;

    public Histories() {
        histories = new ArrayList<>();
    }

    public void add(History history) {
        histories.add(history);
    }

    public List<History> getHistories() {
        return histories;
    }
}
