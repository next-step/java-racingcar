package racingcar.step3.domain;

import racingcar.step3.common.Consts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private Map<String, Integer> turnRecords;
    private final Map<Integer, Map<String, Integer>> totalRecords;
    private int bestRecord;

    public Record() {
        this.turnRecords = new HashMap<>();
        this.totalRecords = new HashMap<>();
        this.bestRecord = Consts.BEST_RECORD_INIT;
    }

    public void record(Car car, int turn) {
        setTurnRecords(car, turn);
        setTotalRecords(turn);
        setBestRecord(car);
    }

    private void setTurnRecords(Car car, int turn) {
        if (!totalRecords.containsKey(turn)) {
            turnRecords = new HashMap<>();
        }
        turnRecords.put(car.getName(), car.getDistance());
    }

    private void setTotalRecords(int turn) {
        totalRecords.put(turn, turnRecords);
    }

    private void setBestRecord(Car car) {
        if (Integer.compare(bestRecord, car.getDistance()) == -1) {
            this.bestRecord = car.getDistance();
        }
    }

    public Map<Integer, Map<String, Integer>> getTotalRecords() {
        return this.totalRecords;
    }

    public int getBestRecord() {
        return this.bestRecord;
    }

}
