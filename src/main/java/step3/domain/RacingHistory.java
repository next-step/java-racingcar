package step3.domain;

import java.util.List;

public class RacingHistory {

    private List<String> firstRankNames;
    private String racerPositionsString;

    public RacingHistory(List<String> firstRankNames, String racerPositionsString) {
        this.firstRankNames = firstRankNames;
        this.racerPositionsString = racerPositionsString;
    }

    public List<String> getFirstRankNames() {
        return firstRankNames;
    }

    public String getRacerPositionsString() {
        return racerPositionsString;
    }
}
