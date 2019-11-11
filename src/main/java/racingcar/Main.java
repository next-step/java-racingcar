package racingcar;

import racingcar.domain.GameResult;
import racingcar.domain.RacingGame;
import racingcar.domain.UserInput;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.createInput();

        UserInput input = inputView.getInput();

        RacingGame game = new RacingGame();
        GameResult gameResult = game.run(input.getCarNames(), input.getRunCount());

        ResultView resultView = new ResultView(gameResult);
        resultView.printRace();
        resultView.printWinner();
    }
}
