package step3;

public class RacingSpec {

    private final Integer carCount;
    private final Integer moveCount;

    public RacingSpec(int carCount, int moveCount) {
        if (carCount <= 0 || moveCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RACING_SPEC);
        }
        this.carCount = carCount;
        this.moveCount = moveCount;
    }

    public Integer getCarCount() {
        return carCount;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
