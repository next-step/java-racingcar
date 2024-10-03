package racingcar;

public class AttemptResult {
    private final int[] carPositions;

    public AttemptResult(int[] positions) {
        this.carPositions = positions;
    }

    public int[] getCarPositions() {
        return this.carPositions;
    }
}
