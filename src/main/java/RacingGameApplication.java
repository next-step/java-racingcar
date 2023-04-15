import game.GameResult;
import game.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        List<String> carNames = InputView.carNameInput();
        int stageInput = InputView.stageInput();

        RacingGame racingGame = new RacingGame(stageInput, carNames);
        racingGame.progress();

        List<GameResult> gameResult = racingGame.getResults();

        ResultView.printResultTitle();
        ResultView.printResult(gameResult);
    }
}
