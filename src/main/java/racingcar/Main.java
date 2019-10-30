package racingcar;

import racingcar.business.Racing;
import racingcar.presentation.InputView;
import racingcar.presentation.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.inputCarNames();
        inputView.inputCountOfMovesAttemps();

        Racing racing = Racing.of(inputView.getCarNames(), inputView.getCountOfMovesAttemps());

        racing.start();

        ResultView resultView = new ResultView(racing);

        resultView.printRacingResult();
    }
}
