package racingcar.dto.output;

import java.util.List;

public class RacingGameRecord {

    private final List<RacingGameResult> value;

    public RacingGameRecord(List<RacingGameResult> racingGameResults) {
        this.value = racingGameResults;
    }

    public List<RacingGameResult> getValue() {
        return value;
    }
}
