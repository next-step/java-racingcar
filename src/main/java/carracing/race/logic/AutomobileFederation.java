package carracing.race.logic;

import carracing.race.logic.type.Record;
import carracing.race.logic.type.Round;
import carracing.race.logic.type.Score;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutomobileFederation {

    private final Map<Round, List<Score>> scoreListResultMap;
    private final Map<Round, Record> recordBoards;
            //scoreboard

    public AutomobileFederation(Map<Round, List<Score>> scoreListResultMap) {
        this.scoreListResultMap = scoreListResultMap;
        this.recordBoards = scoreboardCalculation(scoreListResultMap);

    }

    private Map<Round, Record> scoreboardCalculation(Map<Round, List<Score>> raceResults) {

        for (Round round : getRounds()) {
            for (Score scoreCurrentCar : raceResults.get(round)) {

            }
        }
        return null;
    }

//    public Map<Round, Record> getScoreboard() {
//        return scoreboard;
//    }

//    public List<Integer> getIntRounds() {
//        return scoreListResultMap
//                .keySet()
//                .stream()
//                .map(Round::toInt)
//                .sorted(Comparator.naturalOrder())
//                .collect(Collectors.toList());
//    }

    public List<Round> getRounds() {
        return new ArrayList<>(scoreListResultMap.keySet()).stream().sorted().collect(Collectors.toList());
    }

    public List<String> lapSituations(Round round) {
        Record record = this.recordBoards.get(round);
        return record.toList();
    }
}
