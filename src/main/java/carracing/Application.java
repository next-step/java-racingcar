package carracing;

import carracing.controller.CarRacingGameController;
import carracing.view.InputView;
import carracing.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRacingGameController carRacingGameController = new CarRacingGameController();
        OutputView.printResultOfRacingGame(carRacingGameController.run(InputView.readCarNames(), InputView.readNumberOfTrials()));
    }
}
