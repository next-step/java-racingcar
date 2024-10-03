package racingcar.controller;

import racingcar.service.CarRacing;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarController {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();
    private static final CarRacing carRacing = new CarRacing();

    public static void main(String[] args) {
        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfMoves = inputView.enterNumberOfMoves();

        Car[] carsStatus = carRacing.carRaceReady(numberOfCars);

        System.out.println("실행 결과");
        
        for(int i = 0; i < numberOfMoves; i++) {
            carRacing.carRaceStart(numberOfCars);
            resultView.printCarsStatusResult(carsStatus);
        }
    }
}
