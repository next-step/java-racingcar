package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RaceRecords {

    private final List<RaceRecord> raceRecords;

    public RaceRecords() {
        this.raceRecords = new ArrayList<>();
    }

    public List<RaceRecord> getRaceRecords() {
        return raceRecords;
    }

    public List<String> getWinner() {
        RaceRecord lastRaceRecord = getLastRaceRecord();
        Map<String, Integer> recordsWithCarName = lastRaceRecord.getRecordsWithCarName();
        Integer max = Collections.max(recordsWithCarName.values());
        return getWinnerNames(recordsWithCarName, max);
    }

    private RaceRecord getLastRaceRecord() {
        return getRaceRecords().get(getRaceRecords().size() - 1);
    }

    private List<String> getWinnerNames(Map<String, Integer> map, Integer max) {
        List<String> winners = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name).equals(max)) {
                winners.add(name);
            }
        }
        return winners;
    }

    public void saveSingleRoundRecord(int round, Cars cars) {
        raceRecords.add(cars.saveRecord(round));
    }
}
