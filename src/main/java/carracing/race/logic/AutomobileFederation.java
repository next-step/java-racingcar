package carracing.race.logic;

import carracing.race.logic.type.Record;
import carracing.race.logic.type.Round;
import carracing.race.logic.type.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutomobileFederation {

    private final Map<Round, List<Score>> scoreListResultMap;
    private final Map<Round, Record> recordBoards;

    public AutomobileFederation(Map<Round, List<Score>> scoreListResultMap) {
        this.scoreListResultMap = scoreListResultMap;
        this.recordBoards = recordBoardCalculation(scoreListResultMap);
    }

    private Map<Round, Record> recordBoardCalculation(Map<Round, List<Score>> raceResults) {
        Map<Round, Record> recordMap = new HashMap<>();

        for (Round round : this.getRounds()) {
            List<String> recordThisRound = new ArrayList<>();
            for (Score scoreCurrentCar : raceResults.get(round)) {
                recordThisRound.add(getPreviousProgress() + scoreCurrentCar.toProgress());
            }
            Record record = new Record(recordThisRound);
            recordMap.put(round, record);
        }
        return recordMap;
    }

    private String getPreviousProgress() {
        throw new RuntimeException();
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
