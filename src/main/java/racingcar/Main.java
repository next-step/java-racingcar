package racingcar;

import racingcar.business.Racing;
import racingcar.presentation.InputView;
import racingcar.presentation.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.inputCountOfCars();
        inputView.inputCountOfMovesAttemps();

        Racing racing = new Racing();

        racing.initialize(inputView.getCountOfCars(), inputView.getCountOfMovesAttemps());
        racing.start();

        ResultView resultView = new ResultView();

        resultView.printRacingResult(racing);
    }
}
