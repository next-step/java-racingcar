package racingcar.domain.input;

import racingcar.domain.Round;

public class InputRoundCount {

    private RoundCount roundCount;

    public InputRoundCount(String value) {
        this.roundCount = new RoundCount(value);
    }

    public Round toRound() {
        return new Round(this.roundCount);
    }
}
