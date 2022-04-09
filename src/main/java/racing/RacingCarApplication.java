package racing;

import racing.view.InputView;
import racing.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.getUserInput();

        RacingCarGame racingCarGame = new RacingCarGame(inputView.getNumCars());
        GameResult result = racingCarGame.run(inputView.getNumMoves());

        ResultView resultView = new ResultView();
        resultView.printResult(result);
    }
}

