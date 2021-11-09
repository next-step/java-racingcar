package racingcargame.domain;

import racingcargame.utils.RandomUtil;

import java.util.function.Predicate;

public class RacingCar {
    private int position;

    private Predicate<Integer> moveCondition = (randomInt) -> randomInt >= 4;

    public void move() {
        move(RandomUtil.nextInt(10));
    }

    void move(int moveArgument) {
        if (moveCondition.test(moveArgument)) {
            position++;
        }
    }

    public String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append('-');
        }
        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}
