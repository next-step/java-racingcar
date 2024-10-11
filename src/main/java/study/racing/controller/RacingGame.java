package study.racing.controller;

import study.racing.InputView;
import study.racing.ResultView;
import study.racing.domain.CarRaceInput;
import study.racing.domain.RacingHistory;
import study.racing.service.RacingGameService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

public class RacingGame {

    public void racing() {
        InputView inputView = new InputView();
        CarRaceInput carRaceInput = inputView.readInput();

        RacingGameService racingGameService = new RacingGameService(carRaceInput.getCarCount(), carRaceInput.getRoundCount());
        RacingHistory racingHistory = racingGameService.raceStart(new MoveUnderOneDigitStrategy());

        ResultView resultView = new ResultView();
        resultView.printView(racingHistory);
    }
}
