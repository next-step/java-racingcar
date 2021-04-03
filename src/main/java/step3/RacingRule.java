package step3;

import java.util.Random;

public class RacingRule implements Rule {
    final static int CAN_GO = 4;

    @Override
    public void go(Car car) {
        if (castDice() >= CAN_GO) {
            car.go();
        }
    }

    @Override
    public void go(Car car, int dice) {
        if (dice >= CAN_GO) {
            car.go();
        }
    }

    public int castDice() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
