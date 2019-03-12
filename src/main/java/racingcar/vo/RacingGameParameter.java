package racingcar.vo;

import java.util.Collections;
import java.util.List;

public class RacingGameParameter {
    private final List<String> carNames;
    private final int totalRound;

    public RacingGameParameter(List<String> carNames, int totalRound) {
        this.carNames = carNames;
        this.totalRound = totalRound;
    }

    public List<String> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int getTotalRound() {
        return totalRound;
    }
}
