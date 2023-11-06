package study;

import java.util.concurrent.ThreadLocalRandom;

public class CarRace {

    private static final String EXCEPTION_MSG_UTILITY_CLASS = "Utility class";

    private CarRace(){
        throw new IllegalStateException(EXCEPTION_MSG_UTILITY_CLASS);
    }

    public static int[][] race(RaceEntry raceEntry) {
        int[][] result = new int[raceEntry.carCount()][raceEntry.tryCount()];
        for (int i = 0; i < raceEntry.tryCount(); i++) {
            randomRace(raceEntry.carCount(), result[i]);
        }
        return result;
    }

    private static void randomRace(int carCount, int[] result) {
        for (int j = 0; j < carCount; j++) {
            randomGoForward(result, j);
        }
    }

    private static void randomGoForward(int[] result, int j) {
        if (isGoForward()) {
            result[j]++;
        }
    }

    private static boolean isGoForward() {
        return ThreadLocalRandom.current().nextInt(10) >= 4;
    }
}
