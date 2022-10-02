package racingcar.backend.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {

    private List<Integer> values;

    public GameRecord() {
        this.values = new ArrayList<>();
    }

    public void add(int position) {
        values.add(position);
    }

    public List<Integer> getValues() {
        return values;
    }
}
