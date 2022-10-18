package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameRecord {

    private final List<RacerRecord> racerRecords;

    public GameRecord(final List<RacerRecord> racerRecords) {
        validateRacerRecords(racerRecords);
        this.racerRecords = racerRecords;
    }

    private void validateRacerRecords(final List<RacerRecord> racerRecords) {
        if (racerRecords == null || racerRecords.isEmpty()) {
            throw new IllegalArgumentException("경주 참가자 기록이 누락되었습니다.");
        }
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
