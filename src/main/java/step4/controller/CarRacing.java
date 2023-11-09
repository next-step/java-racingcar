package step4.controller;

import step4.presentation.RacingInputView;
import step4.presentation.RacingResultView;

import java.io.IOException;

public class CarRacing {

    public void startGame() throws IOException {
        CarController carController = new CarController();
        RacingInputView inputView = new RacingInputView(carController);
        RacingResultView resultView = new RacingResultView(carController);

        inputView.inputNumOfCars();
        resultView.printCarRacing(inputView.inputNumOfTry());
    }
}
