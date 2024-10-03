package racing.domain;

import racing.constant.RacePosition;

import java.util.*;

public class RaceRecord {

    private final List<RacePosition> results;
    private final String name;

    private Integer pointTotal;

    public RaceRecord(List<RacePosition> results) {
        this.results = results;
        this.name = "";
    }

    public RaceRecord(String name, List<RacePosition> results) {
        this.name = name;
        this.results = results;
    }

    public RacePosition raceResult(int attempt) {
        return results.get(attempt);
    }

    public String name() {
        return this.name;
    }

    public int totalPoint() {
        if (pointTotal == null) {
            pointTotal = results.stream().mapToInt(RacePosition::getPoint).sum();
        }
        return pointTotal;
    }
}
