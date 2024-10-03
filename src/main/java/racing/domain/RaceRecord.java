package racing.domain;

import java.util.List;

public class RaceRecord {

    private final List<Integer> results;
    private final String name;

    public RaceRecord(List<Integer> results) {
        this.results = results;
        this.name = "";
    }

    public RaceRecord(String name, List<Integer> results) {
        this.name = name;
        this.results = results;
    }

    public int raceResult(int attempt) {
        return results.get(attempt);
    }

    public String name() {
        return this.name;
    }

    public int totalPoint() {
        return results.get(results.size() - 1);
    }
}
