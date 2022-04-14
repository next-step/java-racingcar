package step3;

import step3.model.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

public class RacingGameApp {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        RacingGame racingGame = new RacingGame(inputView.requestStart());
        racingGame.race();

        ResultView resultView = new ResultView();
        resultView.printResult(racingGame.getResult());
    }
}
