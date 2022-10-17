package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameRecord {

    private List<RacerRecord> racerRecords;

    private GameRecord() {
    }

    public GameRecord(final List<RacerRecord> racerRecords) {
        this.racerRecords = racerRecords;
    }

    public static GameRecord from(final Racers racers) {
        List<RacerRecord> racerRecords = racers.getCars().stream()
            .map(RacerRecord::from)
            .collect(Collectors.toList());

        return new GameRecord(racerRecords);
    }

    public List<RacerRecord> getRacerResults() {
        return racerRecords;
    }
}
