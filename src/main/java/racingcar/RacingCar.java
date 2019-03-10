package racingcar;

import java.util.Random;

public class RacingCar {
    private static int RANGE = 9;
    private static int FORWARD_NUM = 4;
    private int position;

    public String printPosition () {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void move() {
        if (this.isMove()) {
            this.position++;
        }
    }

    public boolean isMove() {
        return new Random().nextInt(RANGE) >= FORWARD_NUM;
    }
}
