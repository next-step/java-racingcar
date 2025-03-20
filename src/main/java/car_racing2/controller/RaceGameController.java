package car_racing2.controller;

import car_racing2.model.RaceResult;
import car_racing2.model.RaceService;
import car_racing2.view.InputData;
import car_racing2.view.InputView;
import car_racing2.view.OutputView;

public class RaceGameController {
    private final RaceService raceService = new RaceService();

    public void run() {
        InputData raceData = InputView.getRaceInput();
        RaceResult result = raceService.race(raceData);
        OutputView.showRaceResult(result);
    }
}
