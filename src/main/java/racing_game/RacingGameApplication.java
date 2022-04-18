package racing_game;

import racing_game.controller.RacingGame;
import racing_game.model.GameResult;
import racing_game.model.GameCondition;
import racing_game.view.ResultView;

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
