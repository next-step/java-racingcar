package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingCarController racingCarController = new RacingCarController(
                inputView.receiveNumberOfParticipants(),
                inputView.receiveNumberOfOperations(),
                outputView
        );
        racingCarController.run();

    }
}
