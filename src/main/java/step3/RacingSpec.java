package step3;

public class RacingSpec {

    private final Integer carCount;
    private final Integer moveCount;

    public RacingSpec(Integer carCount, Integer moveCount) {
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
