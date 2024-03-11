package racing.domain;

import java.util.Random;

public class RandomNumber {

    private static final int FORWARDING_CONDITION = 4;

    public static int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
