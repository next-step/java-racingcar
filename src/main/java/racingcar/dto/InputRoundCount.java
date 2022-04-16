package racingcar.dto;

import racingcar.domain.Round;
import racingcar.domain.input.RoundCount;

public class InputRoundCount {

    private RoundCount roundCount;

    public InputRoundCount(String value) {
        this.roundCount = new RoundCount(value);
    }

    public Round toRound() {
        return new Round(this.roundCount);
    }
}
