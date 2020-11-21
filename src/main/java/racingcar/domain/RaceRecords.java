package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

    public Map<String, Integer> saveRecords(Cars cars) {
        Map<String, Integer> map = new HashMap<>();
        for (Car car : cars.getCars()) {
            map.put(car.getName(), car.getLocation());
        }
        return map;
    }

    public String getWinner() {
        RaceRecord lastRaceRecord = getLastRaceRecord();
        Map<String, Integer> recordsWithCarName = lastRaceRecord.getRecordsWithCarName();
        Integer max = Collections.max(recordsWithCarName.values());
        return getWinnerNames(recordsWithCarName, max);
    }

    private RaceRecord getLastRaceRecord() {
        return getRaceRecords().get(getRaceRecords().size() - 1);
    }

    private String getWinnerNames(Map<String, Integer> map, Integer max) {
        StringBuilder winners = new StringBuilder();
        for (String name : map.keySet()) {
            if (map.get(name).equals(max)) {
                winners.append(name).append(", ");
            }
        }
        return winners.toString();
    }
}
