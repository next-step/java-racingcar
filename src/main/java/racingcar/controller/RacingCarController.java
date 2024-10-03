package racingcar.controller;

import racingcar.service.CarRacing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfMoves = inputView.enterNumberOfMoves();

        CarRacing carRacing = new CarRacing(numberOfCars);
        ResultView resultView = new ResultView(carRacing);

        for(int i = 0; i < numberOfMoves; i++) {
            carRacing.carRaceStart();
            resultView.printCarsStatusResult();
        }
    }
}
