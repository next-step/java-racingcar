package racing.controller;

import racing.model.RaceResult;
import racing.service.RacingGameService;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingGameController {

    public void start() {
        String[] names = InputView.getCarNames();
        int count = InputView.getGameCount();
        RacingGameService racingGameService = new RacingGameService();

        ResultView.printResultTitle();
        RaceResult raceResult = racingGameService.race(names, count);

        ResultView.printResult(raceResult);
    }
}
