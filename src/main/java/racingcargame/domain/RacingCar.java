package racingcargame.domain;

import racingcargame.utils.RandomUtil;

public class RacingCar {
    private int currentPosition;

    public void move() {
        if (canMove()) {
            currentPosition++;
        }
    }

    public boolean canMove() {
        return RandomUtil.nextInt(10) >= 4;
    }

    public String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentPosition; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
