package racingcargame;

import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        RacingCarGame game = new RacingCarGame(new InputView(), new ResultView());
        game.start();
    }
}
