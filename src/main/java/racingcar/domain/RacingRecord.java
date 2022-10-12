package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingRecord {

    private List<RacerRecord> racerRecords;

    private RacingRecord() {
    }

    public RacingRecord(final List<RacerRecord> racerRecords) {
        this.racerRecords = racerRecords;
    }

    public static RacingRecord from(final Racers racers) {
        List<RacerRecord> racerRecords = racers.getCars().stream()
            .map(RacerRecord::from)
            .collect(Collectors.toList());

        return new RacingRecord(racerRecords);
    }

    public List<RacerRecord> getRacerResults() {
        return racerRecords;
    }
}
