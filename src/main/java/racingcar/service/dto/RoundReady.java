package racingcar.service.dto;

import racingcar.service.value.Round;
import racingcar.service.strategy.RoundRule;
import racingcar.utils.Preconditions;

import java.util.List;

public class RoundReady {
    private final RoundRule roundRule;
    private final List<String> carNames;
    private final Round finalRound;

    private RoundReady(RoundRule roundRule, List<String> carNames, Round finalRound) {
        Preconditions.checkNotNull(roundRule, "roundRule은 필수값입니다.");
        Preconditions.checkNotNull(carNames, "carNames는 필수값입니다.");
        Preconditions.checkNotNull(finalRound, "finalRound는 필수값입니다.");

        this.roundRule = roundRule;
        this.carNames = carNames;
        this.finalRound = finalRound;
    }

    public static RoundReady of(RoundRule roundRule, List<String> carName, Round finalRound) {
        return new RoundReady(roundRule, carName, finalRound);
    }

    public RoundRule getRoundRule() {
        return roundRule;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Round getFinalRound() {
        return finalRound;
    }
}
