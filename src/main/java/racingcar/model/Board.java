package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Integer>> racingRecord;

    public Board() {
        this.racingRecord = new ArrayList<>();
    }

    public void record(List<Integer> carsPositions) {
        racingRecord.add(carsPositions);
    }

    public List<List<Integer>> getAllRecords() {
        return racingRecord;
    }
}
