package step_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingCar {

    private final static int FORWARD_CONDITION = 4;
    private final List<Integer> roundResults;

    public RacingCar(int totalRound) {
        this.checkNegativeArgs(totalRound);
        this.roundResults = new ArrayList<>(totalRound);
    }

    public void stopOrForward(int thisRound) {
        this.checkNegativeArgs(thisRound);
        this.roundResults.add(thisRound, Roulette.spin());
    }

    public int forwardHistory() {
        return (int) this.roundResults.stream()
                .filter(result -> result >= FORWARD_CONDITION)
                .count();
    }

    private void checkNegativeArgs(int... args) {
        boolean hasNegative = Arrays.stream(args).anyMatch(arg -> arg < 0);
        if (hasNegative) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }
}
