/*
 * RacingCarGame
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame.ui;

public class AbstractView implements View {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
