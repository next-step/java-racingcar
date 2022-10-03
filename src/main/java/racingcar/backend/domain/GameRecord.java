package racingcar.backend.domain;

import java.util.*;

public class GameRecord {

    private List<Map<String, Integer>> values;

    public GameRecord() {
        this.values = new ArrayList<>();
    }

    public void add(Map<String, Integer> record) {
        values.add(record);
    }

    public List<Map<String, Integer>> getValues() {
        return new ArrayList<>(values);
    }
}
