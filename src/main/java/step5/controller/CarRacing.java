package step5.controller;

import step5.presentation.RacingInputView;
import step5.presentation.RacingResultView;

import java.util.function.Supplier;

public class CarRacing {

    private final RacingInputView inputView;
    private final RacingResultView resultView;

    public CarRacing() {
        CarController carController = new CarController();
        this.inputView = new RacingInputView(carController);
        this.resultView = new RacingResultView(carController);
    }

    public void startGame() {
        int numOfCars = repeatUntilWorkCorrect(inputView::inputNameOfCars);
        int numOfTry = repeatUntilWorkCorrect(inputView::inputNumOfTry);

        resultView.printCarRacing(numOfCars, numOfTry);
    }

    private int repeatUntilWorkCorrect(Supplier<Integer> supplier) {
        int result;
        while (true) {
            try {
                result = supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            break;
        }
        return result;
    }
}
