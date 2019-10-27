package racing;

import java.util.Arrays;

class RacingScoreView {

    private static final char CAR_TOKEN = '-';
    private final int[] raceResults;

    RacingScoreView(int[] racingResults) {
        this.raceResults = racingResults;
    }

    void printResult() {
        for (int raceResult : raceResults) {
            char[] result = new char[raceResult];
            Arrays.fill(result, CAR_TOKEN);
            System.out.println(result);
        }
    }
}
