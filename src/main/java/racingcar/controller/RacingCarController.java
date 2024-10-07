package racingcar.controller;

import racingcar.model.RaceRecord;
import racingcar.service.CarRacing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarController {
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        String[] carNames = inputView.enterCarNames().split(",");
        int totalNumberOfRace = inputView.enterNumberOfRace();

        CarRacing carRacing = new CarRacing(carNames);
        ResultView resultView = new ResultView();

        for(int raceCount = 1; raceCount <= totalNumberOfRace; raceCount++) {
            List<RaceRecord> records = carRacing.carRaceStart();
            resultView.printRacingResult(records, raceCount, totalNumberOfRace);
        }
    }
}
