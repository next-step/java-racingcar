package race;

import java.util.Random;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }

    public static boolean canGo(int number) {
        return number >= 4;
    }

    public static int[] initiateCarStates(int carCount) {
        return new int[carCount];
    }
}
