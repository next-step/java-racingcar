package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarRacing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        List<String> carNames = inputView.enterCarNames();
        int totalNumberOfRace = inputView.enterNumberOfRace();

        CarRacing carRacing = new CarRacing(carNames);
        ResultView resultView = new ResultView();

        for (int raceCount = 1; raceCount <= totalNumberOfRace; raceCount++) {
            List<Car> records = carRacing.carRaceStart();
            resultView.printRacingResult(records, raceCount, totalNumberOfRace);
        }
    }
}
