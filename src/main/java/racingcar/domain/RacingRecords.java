package racingcar.domain;

import java.util.List;

public class RacingRecords {

    private final List<RacingRecord> racingRecords;

    public RacingRecords(List<RacingRecord> racingRecords) {
        this.racingRecords = racingRecords;
    }

    public List<RacingRecord> getRacingRecords() {
        return racingRecords;
    }

    public Car getRacingRecordsInCar(int index) {
        return racingRecords.get(index).getCar();
    }
}
