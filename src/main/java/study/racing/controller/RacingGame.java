package study.racing.controller;

import study.racing.InputView;
import study.racing.ResultView;
import study.racing.domain.Input;
import study.racing.domain.RacingHistory;
import study.racing.service.RacingGameService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

public class RacingGame {

    public void racing() {
        InputView inputView = new InputView();
        Input input = inputView.readInput();

        RacingGameService racingGameService = new RacingGameService(input.getCarCount(), input.getRoundCount());
        RacingHistory racingHistory = racingGameService.raceStart(new MoveUnderOneDigitStrategy());

        ResultView resultView = new ResultView();
        resultView.printView(racingHistory);
    }
}
