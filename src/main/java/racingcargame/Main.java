/*
 * Main
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame;

import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(new InputView(), new ResultView());
        game.start();
    }
}
