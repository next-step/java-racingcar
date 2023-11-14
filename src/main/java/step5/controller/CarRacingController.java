package step5.controller;

import step5.domain.CarRacing;
import step5.presentation.RacingInputView;
import step5.presentation.RacingResultView;

import java.util.function.Supplier;

public class CarRacingController {

    private final CarRacing carRacing;
    private final RacingInputView inputView;
    private final RacingResultView resultView;

    public CarRacingController() {
        this.carRacing = new CarRacing();
        this.inputView = new RacingInputView(carRacing);
        this.resultView = new RacingResultView(carRacing);
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
