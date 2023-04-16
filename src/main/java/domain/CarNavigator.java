package domain;

import java.util.Random;

public class CarNavigator {

    private static final int HEADS_OR_TAILS = 4;
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);
    }
    public static boolean flipCoin(int coin) {
        return coin >= HEADS_OR_TAILS;
    }
}
