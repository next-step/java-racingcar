package racingcar;

import java.util.Random;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private static final int RANGE = 9;
    private int position;

    public String printPosition () {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public void move() {
        if (this.isMove(new NumberWithRandom(RANGE))) {
            this.position++;
        }
    }

    public boolean isMove(RandomStrategy randomStrategy) {
        return randomStrategy.makeRandomNumber() > FORWARD_NUM;
    }
}
