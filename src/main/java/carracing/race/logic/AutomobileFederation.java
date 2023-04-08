package carracing.race.logic;

import java.util.List;
import java.util.Map;

public class AutomobileFederation {

    private final Map<Integer, List<Integer>> raceResults;
    private final Map<Integer, List<String>> scoreboard;
            //scoreboard

    public AutomobileFederation(Map<Integer, List<Integer>> raceResults) {
        this.raceResults = raceResults;
        this.scoreboard = scoreboardCalculation(raceResults);

    }

    private Map<Integer, List<String>> scoreboardCalculation(Map<Integer, List<Integer>> raceResults) {
    }
}
