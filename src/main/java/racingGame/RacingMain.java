package racingGame;

import racingGame.factory.RacingGameDefaultFactory;
import racingGame.view.InputView;
import racingGame.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGameDefaultFactory racingGameDefaultFactory = new RacingGameDefaultFactory();
        RacingGame racingGame = racingGameDefaultFactory.createRacingGame(new InputView(), new ResultView());
        racingGame.play();
    }
}
