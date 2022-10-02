package thirdStep.logic;

import thirdStep.View.InputView;

import java.util.Random;
import java.util.stream.IntStream;

public class Race {
    private static Random random = new Random();
    private static int carCount = InputView.getCarCount();
    private static int[] carStatus = new int[carCount];

    public static int getRandomNumber() {
        return random.nextInt(9);
    }

    public static void startOneRace() {
        IntStream.range(0, carCount).forEach(index -> carMove(index, getRandomNumber()));
    }

    public static void carMove(int index, int randomNumber) {
        if (randomNumber >= 4) {
            carStatus[index] += 1;
        }
    }

    public static int[] getCarStatus() {
        return carStatus;
    }
}
