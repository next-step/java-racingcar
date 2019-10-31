package racingcar;

import racingcar.domain.RacingCycle;
import racingcar.domain.RacingGame;
import racingcar.domain.UserInput;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.createInput();

        UserInput input = inputView.getInput();

        RacingGame game = new RacingGame(input.getCarNames(), input.getRunCount());
        List<RacingCycle> cycles = game.getCycles();

        ResultView resultView = new ResultView(cycles);
        resultView.printRace();
        resultView.printWinner();
    }
}
