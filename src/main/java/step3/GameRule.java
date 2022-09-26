package step3;

import java.util.Random;

public class GameRule {

    private static final Random random = new Random();

    public static int decideMove(int num) {
        if (num < 4) {
            return 0;
        }
        return 1;
    }

    public static int createRandomNum() {
        return random.nextInt(10);
    }
}
