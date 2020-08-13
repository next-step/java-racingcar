package racing.core;

import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.Random;

public class GameRunner {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGame game = new RacingGame(inputView.howManyCars(), inputView.howManyTrials());
        ResultView resultView = game.run(new Random());
        resultView.printResult();
    }
}
