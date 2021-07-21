package step3;

import step3.game.Game;
import step3.game.GameEnv;
import step3.view.InputView;
import step3.view.ResultView;

public class App {
    public static final int CRITERION_NUMBER = 4;
    public static final int RANGE_MIN = 0;
    public static final int RANGE_MAX = 9;

    public static void main(String[] args) {
        GameEnv gameEnv = InputView.initGameEnv();

        Game game = gameEnv.createGame();
        game.run();

        ResultView.showResult(game);
    }
}
