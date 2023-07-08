package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {

    private final List<RacingRoundRecord> racingRoundRecords;

    public RacingRecord(List<RacingRoundRecord> racingRoundRecords) {
        if (racingRoundRecords == null) {
            throw new RuntimeException("racing record 생성 시 racing round records가 null이면 안됩니다.");
        }
        this.racingRoundRecords = racingRoundRecords;
    }

    public RacingRecord() {
        this(new ArrayList<>());
    }

    public void add(RacingRoundRecord racingRoundRecord) {
        racingRoundRecords.add(racingRoundRecord);
    }

    public List<RacingRoundRecord> getRacingRoundRecords() {
        return racingRoundRecords;
    }
}
