package racingcar;

import java.util.Random;

public class RacingCar {
    public static final char CAR_MOVE_STATE = '-';

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public boolean move(int randomNumber) {
        return randomNumber >= 4;
    }

    public String makeLine(int moveCount) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < moveCount; i++) {
            sb.append(CAR_MOVE_STATE);
        }
        return sb.toString();
    }
}
