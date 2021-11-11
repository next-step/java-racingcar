/*
 * RacingCar
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame.domain;

import java.util.function.Predicate;
public class RacingCar {

    private int position;

    private Predicate<Integer> moveCondition = (randomInt) -> randomInt >= 4;

    public void move(int moveArgument) {
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
