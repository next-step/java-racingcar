package racingcar.service.dto;

import racingcar.service.strategy.RoundRule;
import racingcar.utils.Preconditions;

import java.util.List;

public class RoundReadyDTO {
    private final RoundRule roundRule;
    private final List<String> carNames;
    private final Integer totalRoundCount;

    private RoundReadyDTO(RoundRule roundRule, List<String> carNames, Integer totalRoundCount) {
        Preconditions.checkNotNull(roundRule, "roundRule은 필수값입니다.");
        Preconditions.checkNotNull(carNames, "carNames는 필수값입니다.");
        Preconditions.checkNotNull(totalRoundCount, "totalRoundCount는 필수값입니다.");

        this.roundRule = roundRule;
        this.carNames = carNames;
        this.totalRoundCount = totalRoundCount;
    }

    public static RoundReadyDTO of(RoundRule roundRule, List<String> carName, Integer totalRoundCount) {
        return new RoundReadyDTO(roundRule, carName, totalRoundCount);
    }

    public RoundRule getRoundRule() {
        return roundRule;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getTotalRoundCount() {
        return totalRoundCount;
    }
}
