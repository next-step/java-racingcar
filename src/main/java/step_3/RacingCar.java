package step_3;

import java.util.Arrays;

public class RacingCar {

    private final int[] roundResults;

    public RacingCar(int totalRound) {
        this.checkNegativeArgs(totalRound);
        this.roundResults = new int[totalRound];
    }

    public void stopOfForward(int thisRound, int roundResult) {
        this.checkNegativeArgs(thisRound, roundResult);
        this.roundResults[thisRound] = roundResult;
    }

    public long forwardHistory() {
        return Arrays.stream(this.roundResults).filter(roundResult -> roundResult >= 4).count();
    }

    private void checkNegativeArgs(int... args) {
        boolean hasNegative = Arrays.stream(args).anyMatch(arg -> arg < 0);
        if (hasNegative) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }
}
