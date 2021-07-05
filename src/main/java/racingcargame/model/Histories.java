package racingcargame.model;

import java.util.ArrayList;
import java.util.List;

public class Histories {
    private List<History> histories;

    public Histories(List<History> histories) {
        this.histories = new ArrayList<>(histories);
    }

    public List<History> getHistories() {
        return histories;
    }
}
