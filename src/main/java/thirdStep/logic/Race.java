package thirdStep.logic;

import thirdStep.View.InputView;
import java.util.Random;

public class Race {
    public static Random random = new Random();
    public static int carCount = InputView.getCarCount();
    public static int[] carStatus = new int[carCount];

    public static int getRandomNumber() {
        return random.nextInt(9);
    }

    public static void startOneRace() {
        for (int index : carStatus) {
            carMove(index, getRandomNumber());
        }
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
