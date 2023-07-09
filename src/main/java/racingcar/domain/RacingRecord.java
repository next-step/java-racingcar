package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingRecord {

    private final List<RacingRoundRecord> racingRoundRecords;

    public RacingRecord(RacingRoundRecord racingRoundRecord) {
        if (racingRoundRecord == null) {
            throw new RuntimeException("racing record 생성 시 racing round records가 null이면 안됩니다.");
        }
        this.racingRoundRecords = new ArrayList<>(Arrays.asList(racingRoundRecord));
    }

    public void add(RacingRoundRecord racingRoundRecord) {
        racingRoundRecords.add(racingRoundRecord);
    }

    public List<RacingRoundRecord> getRacingRoundRecords() {
        return racingRoundRecords;
    }
}
