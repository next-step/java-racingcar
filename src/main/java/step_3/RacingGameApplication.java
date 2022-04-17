package step_3;

import step_3.controller.RacingGame;
import step_3.model.GameResult;
import step_3.model.GameCondition;
import step_3.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        new RacingGameApplication().run(args);
    }

    public void run(String[] args) {
        GameCondition gameCondition = new GameCondition();
        RacingGame racingGame = new RacingGame(gameCondition);
        GameResult gameResult = racingGame.gameStart();
        ResultView.printResult(gameResult);
    }
}
