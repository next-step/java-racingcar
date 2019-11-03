package racingcar;

import racingcar.domain.Cycles;
import racingcar.domain.RacingGame;
import racingcar.domain.UserInput;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.createInput();

        UserInput input = inputView.getInput();

        RacingGame game = new RacingGame(input.getCarNames(), input.getRunCount());

        ResultView resultView = new ResultView(game.getCycles());
        resultView.printRace();
        resultView.printWinner();
    }
}
