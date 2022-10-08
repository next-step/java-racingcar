package racingcar.backend.domain;

import java.util.*;

public class GameRecord {

    private Map<CarName, Position> value;

    public GameRecord(Map<CarName, Position> record) {
        this.value = record;
    }

    public static GameRecord create(Map<CarName, Position> record) {
        return new GameRecord(record);
    }

    public Map<CarName, Position> getValue() {
        return value;
    }
}
