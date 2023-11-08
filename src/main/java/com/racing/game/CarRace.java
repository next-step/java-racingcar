package com.racing.game;

import com.racing.game.dto.RaceEntry;
import com.racing.game.dto.RaceResult;
import java.util.Arrays;
import java.util.Random;

public class CarRace {

    private static final Random random = new Random();

    private static final String EXCEPTION_MSG_UTILITY_CLASS = "Utility class";

    private CarRace() {
        throw new IllegalStateException(EXCEPTION_MSG_UTILITY_CLASS);
    }

    public static RaceResult race(RaceEntry raceEntry) {
        return RaceResult.of(
                Arrays.stream(new int[raceEntry.tryCount()][raceEntry.carCount()])
                        .map(CarRace::randomRace).toArray(int[][]::new));
    }

    private static int[] randomRace(int[] input) {
        return Arrays.stream(input).map(CarRace::randomGoForward).toArray();
    }

    private static int randomGoForward(int input) {
        if (isGoForward()) {
            return input + 1;
        }
        return input;
    }

    private static boolean isGoForward() {
        return random.nextInt(10) >= 4;
    }
}
