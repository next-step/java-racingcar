package step3;

import java.util.Random;

public class GameRule {

    public static int decideMove(int num) {
        if (num < 4) {
            return 0;
        }
        return 1;
    }

    public static int randomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
