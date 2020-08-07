package racingcar;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {

    private static int[] racingResult;

    public static int getRandomValueUnder10() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean isGreaterThan3(int randomNum) {
        return randomNum > 3;
    }

    public static int run() {
        int randomNum = getRandomValueUnder10();
        boolean isGreaterThan3 =  isGreaterThan3(randomNum);
        return isGreaterThan3==true?randomNum:0;

    }

    public static int[] racing(int racingCount) {
        racingResult = new int[racingCount];

        Arrays.stream(racingResult).forEach(val -> run());

        return racingResult;
    }

    public static int getRacingResult(int racingTurn) {
        return racingResult[racingTurn-1];
    }
}
