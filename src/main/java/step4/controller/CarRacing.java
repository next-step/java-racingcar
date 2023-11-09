package step4.controller;

import step4.presentation.RacingInputView;
import step4.presentation.RacingResultView;

import java.io.IOException;

public class CarRacing {

    public void startGame() throws IOException {
        CarController carController = new CarController();
        RacingInputView inputView = new RacingInputView(carController);
        RacingResultView resultView = new RacingResultView(carController);

        loopUntilNameOfCarsIsCorrect(inputView);
        int numOfTry = loopUntilNumOfTryIsCorrect(inputView);

        resultView.printCarRacing(numOfTry);
    }

    private int loopUntilNumOfTryIsCorrect(RacingInputView inputView) throws IOException {
        int numOfTry;
        while (true) {
            try {
                numOfTry = inputView.inputNumOfTry();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        return numOfTry;
    }

    private void loopUntilNameOfCarsIsCorrect(RacingInputView inputView) throws IOException {
        while (true) {
            try {
                inputView.inputNameOfCars();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
    }
}
