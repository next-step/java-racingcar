package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRecords {

    private List<RacingRecord> racingRecords;

    public RacingRecords() {
        racingRecords = new ArrayList<>();
    }

    public RacingRecords(List<RacingRecord> records) {
        this.racingRecords = new ArrayList<>(records);
    }

    public List<RacingRecord> getRacingRecords() {
        return Collections.unmodifiableList(racingRecords);
    }

    public RacingRecord readRacingRecord(int index) {
        return racingRecords.get(index);
    }

}
