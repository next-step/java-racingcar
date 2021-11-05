package racingcar;

import racingcar.model.RacingGameRequest;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingGameRequest request = inputView.inputRacingGame();

        OutputView outputView = new OutputView(request);
        outputView.printPlayRacing();
    }
}
