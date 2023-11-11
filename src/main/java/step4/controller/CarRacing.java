package step4.controller;

import step4.presentation.RacingInputView;
import step4.presentation.RacingResultView;

public class CarRacing {

    public void startGame() {
        CarController carController = new CarController();
        RacingInputView inputView = new RacingInputView(carController);
        RacingResultView resultView = new RacingResultView(carController);

        loopUntilNameOfCarsIsCorrect(inputView);
        int numOfTry = loopUntilNumOfTryIsCorrect(inputView);

        resultView.printCarRacing(numOfTry);
    }

    private int loopUntilNumOfTryIsCorrect(RacingInputView inputView) {
        int numOfTry;
        while (true) {
            try {
                numOfTry = inputView.inputNumOfTry();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        return numOfTry;
    }

    private void loopUntilNameOfCarsIsCorrect(RacingInputView inputView) {
        while (true) {
            try {
                inputView.inputNameOfCars();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
    }
}
