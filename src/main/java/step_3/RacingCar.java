package step_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final static int MAX_ROULETTE_SCORE = 10;
    private final Random roulette;
    private final List<Integer> roundResults;

    public RacingCar(int totalRound) {
        this.checkNegativeArgs(totalRound);
        this.roundResults = new ArrayList<>(totalRound);
        this.roulette = new Random();
    }

    public int stopOrForward(int thisRound) {
        this.checkNegativeArgs(thisRound);
        this.roundResults.add(thisRound, roulette.nextInt(MAX_ROULETTE_SCORE));

        return this.roundResults.get(thisRound);
    }

    public int forwardHistory() {
        return (int) this.roundResults.stream()
                .filter(roundResult -> roundResult >= 4)
                .count();
    }

    private void checkNegativeArgs(int... args) {
        boolean hasNegative = Arrays.stream(args).anyMatch(arg -> arg < 0);
        if (hasNegative) {
            throw new IllegalArgumentException("음수는 허용하지 않습니다.");
        }
    }
}
