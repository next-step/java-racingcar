package racingcar.util;


import java.util.Random;

public class RandomNumberGenerator {

   private static final Random random = new Random();
   private static final int START_NUMBER = 0;
   private static final int END_NUMBER = 9;

    public static int generateNumber() {
        return random.nextInt(END_NUMBER - START_NUMBER + 1) + START_NUMBER;
    }
}
