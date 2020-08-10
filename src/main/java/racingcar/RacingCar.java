package racingcar;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {

    int[] racingResult;

    public int[] racing(int racingCount) {
        racingResult = new int[racingCount];

        for(int i=0;i<racingCount;i++) {
            racingResult[i] = run();
        }
        return racingResult;
    }

    public int run() {
        int randomNum = getRandomValueUnder10();
        boolean isGreaterThan3 =  isGreaterThan3(randomNum);
        return isGreaterThan3==true?randomNum:0;

    }
    public int getRandomValueUnder10() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public boolean isGreaterThan3(int randomNum) {
        return randomNum > 3;
    }

    public int getRacingResult(int racingTurn) {
        return racingResult[racingTurn-1];
    }
}
