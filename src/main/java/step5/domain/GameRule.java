package step5.domain;

import java.util.Random;

public class GameRule {

    private static final Random random = new Random();

    public static void decideMove(int num, Car car) {
        if (num >= 4) {
            car.moveForward();
        }
    }

    public static int createRandomNum() {
        return random.nextInt(10);
    }
}
