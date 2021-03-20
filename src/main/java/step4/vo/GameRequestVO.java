package step4.vo;

import java.util.List;

public class GameRequestVO {
    private final List<String> carNames;
    private final int roundCount;

    private GameRequestVO(final List<String> carNames, final int roundCount) {
        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    public static GameRequestVO of(final List<String> carNames, final int roundCount) {
        return new GameRequestVO(carNames, roundCount);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }
}
