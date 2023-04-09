package carracing.logic;

import carracing.logic.type.Record;
import carracing.logic.type.Round;
import carracing.logic.type.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AutomobileFederation {
    private static final String INITIAL_RACING_RECODE = "";
    private final Map<Round, List<Score>> roundToScoreListMap;
    private final Map<Round, Record> roundToRecordMap;

    public AutomobileFederation(Map<Round, List<Score>> roundToScoreListMap) {
        this.roundToScoreListMap = roundToScoreListMap;
        this.roundToRecordMap = recordBoardCalculation(roundToScoreListMap);
    }

    private static boolean isFirstRound(Round round) {
        return round.toInt() == 1;
    }

    public Map<Round, Record> recordBoardCalculation(Map<Round, List<Score>> raceResults) {
        Map<Round, Record> recordMap = new HashMap<>();

        for (Round round : this.getRounds()) {
            List<String> recordThisRound = new ArrayList<>();

            for (int carIndex = 0; carIndex < raceResults.get(round).size(); carIndex++) {
                //for (Score scoreCurrentCar : raceResults.get(round)) {
                Score scoreCurrentCar = raceResults.get(round).get(carIndex);
                recordThisRound.add(getPreviousProgress(round, carIndex, recordMap) + scoreCurrentCar.toProgress());
            }
            Record record = new Record(recordThisRound);
            recordMap.put(round, record);
        }
        return recordMap;
    }

    private String getPreviousProgress(Round round, int carIndex, Map<Round, Record> curRecordMap) {
        if (isFirstRound(round)) {
            return INITIAL_RACING_RECODE;
        }
        return curRecordMap.get(round.previousRound()).toList().get(carIndex);
    }

    public List<Round> getRounds() {
        return new ArrayList<>(roundToScoreListMap.keySet())
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> lapSituations(Round round) {
        Record record = this.roundToRecordMap.get(round);
        return record.toList();
    }
}
