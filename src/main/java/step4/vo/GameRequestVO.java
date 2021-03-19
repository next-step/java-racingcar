package step4.vo;

public class GameRequestVO {
    private String carNames;
    private int roundCount;

    private GameRequestVO(final String carNames, final int roundCount) {
        this.carNames = carNames;
        this.roundCount = roundCount;
    }

    public static GameRequestVO of(final String carNames, final int roundCount) {
        return new GameRequestVO(carNames, roundCount);
    }
}
