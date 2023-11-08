package step3.controller;

import step3.presentation.RacingInputView;
import step3.presentation.RacingResultView;

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
