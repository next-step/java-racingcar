package racingcar.dto.output;

import java.util.List;

public class RacingGameResponse {

    private final List<RacingGameRecord> racingGameRecords;
    private final List<String> winners;

    public RacingGameResponse(List<RacingGameRecord> racingGameRecords, List<String> winners) {
        this.racingGameRecords = racingGameRecords;
        this.winners = winners;
    }

    public List<RacingGameRecord> getRacingGameRecords() {
        return racingGameRecords;
    }

    public List<String> getWinners() {
        return winners;
    }
}
