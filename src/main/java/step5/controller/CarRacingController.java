package step5.controller;

import step5.domain.Cars;
import step5.presentation.RacingInputView;
import step5.presentation.RacingResultView;
import step5.util.NumberUtil;

public class CarRacingController {

    private final RacingInputView inputView;
    private final RacingResultView resultView;

    public CarRacingController() {
        this.inputView = new RacingInputView();
        this.resultView = new RacingResultView();
    }

    public void startGame() {
        String[] nameOfCars = inputView.inputNameOfCars();
        Cars cars = new Cars(nameOfCars);

        int numOfTry = inputView.inputNumOfTry();
        tryMove(numOfTry, cars);

        resultView.printWinners(cars.findWinningCarsName());
    }

    private void tryMove(int numOfTry, Cars cars) {
        for (int i = 0; i< numOfTry; i++) {
            cars.moveCars(NumberUtil.createRandomNumbers(cars.countCars()));
            resultView.printCars(cars);
        }
    }
}
