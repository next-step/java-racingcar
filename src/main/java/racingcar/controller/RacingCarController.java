package racingcar.controller;

import racingcar.model.CarRecord;
import racingcar.service.CarRacing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        int numberOfCars = inputView.enterNumberOfCars();
        int numberOfMoves = inputView.enterNumberOfMoves();

        CarRacing carRacing = new CarRacing(numberOfCars);
        ResultView resultView = new ResultView();

        for(int i = 0; i < numberOfMoves; i++) {
            List<CarRecord> records = carRacing.carRaceStart();
            resultView.printRacingResult(records);
        }
    }
}
