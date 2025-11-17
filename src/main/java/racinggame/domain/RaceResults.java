package racinggame.domain;

import java.util.List;

public class RaceResults {
    private final List<RaceResult> results;

    public RaceResults(List<RaceResult> results) {
        this.results = results;
    }

    // 우승자를 찾는 로직을 어디서 구현하면 좋을까?
}
