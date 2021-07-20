package racingcar;

import java.util.Random;

public class CreateRandomNumber {
    private static final int MAX = 10;

    public static int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(MAX);
    }
}
