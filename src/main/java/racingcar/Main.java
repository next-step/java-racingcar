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
        Cycles cycles = game.getCycles();

        ResultView resultView = new ResultView(cycles);
        resultView.printRace();
        resultView.printWinner();
    }
}
