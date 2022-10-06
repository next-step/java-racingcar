package racingGame;

import racingGame.factory.NamingCarFactory;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView(), new ResultView(), new NamingCarFactory());
        racingGame.play();
    }
}
