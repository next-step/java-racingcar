package racing.race;

import java.util.*;

public class RaceRecord {

    private final List<RacePosition> results;
    private final String name;

    private Integer totalPoint;

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
        if (totalPoint == null) {
            totalPoint = results.stream().mapToInt(RacePosition::getPoint).sum();
        }
        return totalPoint;
    }
}
