import game.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGameApplication {
    public static void main(String[] args) {
        int carInput = InputView.carInput();
        int stageInput = InputView.stageInput();

        RacingGame racingGame = new RacingGame(carInput, stageInput);
        racingGame.progress();

        List<List<Integer>> gameResult = racingGame.getResults();

        ResultView.printResultTitle();
        ResultView.printResult(gameResult);
    }
}
