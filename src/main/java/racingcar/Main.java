package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.Records;
import racingcar.domain.UserInput;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.createInput();

        UserInput input = inputView.getInput();

        RacingGame game = new RacingGame();
        List<Records> records = game.run(input.getCarNames(), input.getRunCount());

        ResultView resultView = new ResultView(records);
        resultView.printRace();
        resultView.printWinner();
    }
}
