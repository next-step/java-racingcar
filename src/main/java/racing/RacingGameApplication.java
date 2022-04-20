package racing;

import racing.controller.RacingGame;
import racing.model.GameCondition;
import racing.model.RoundResult;
import racing.view.ResultView;

public class RacingGameApplication {

    public static void main(String[] args) {
        new RacingGameApplication().run(args);
    }

    public void run(String[] args) {
        GameCondition gameCondition = new GameCondition();
        RacingGame racingGame = new RacingGame(gameCondition);
        RoundResult roundResult = racingGame.gameStart();
        ResultView.printResult(roundResult);
    }
}
