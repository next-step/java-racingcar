package race;

import java.util.Random;

public class Race {
    public static final int RANDOM_UPPER_LIMIT = 10;
    public static final int MINIMUM_TO_GO_FORWARD = 4;

    private static int generateIntBetween0and9() {
        return new Random().nextInt(RANDOM_UPPER_LIMIT);
    }

    public static boolean canGo(int number) {
        return number >= MINIMUM_TO_GO_FORWARD;
    }

    public static int[] initiateCarStates(int carCount) {
        return new int[carCount];
    }

    public static void moveCarForward(int[] carStates, int carIndex) {
        carStates[carIndex]++;
    }

    public static void start() {
        RaceInput raceInput = InputView.inputCarCountAndRandomStopOrGoCount();
        int[] carStates = initiateCarStates(raceInput.carCount());

        ResultView.printResultTitle();
        for (int stopOrGoRound = 0; stopOrGoRound < raceInput.randomStopOrGoCount(); stopOrGoRound++) {
            runStopOrGoRound(raceInput.carCount(), carStates);
        }
    }

    private static void runStopOrGoRound(int carCount, int[] carStates) {
        for (int carIndex = 0; carIndex < carCount; carIndex++) {
            moveCarForwardIfCanGo(carStates, carIndex);
        }
        ResultView.printCarStates(carStates);
    }

    private static void moveCarForwardIfCanGo(int[] carStates, int carIndex) {
        if (canGo(generateIntBetween0and9())) {
            moveCarForward(carStates, carIndex);
        }
    }
}
