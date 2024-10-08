package study.racing.controller;

import study.racing.InputView;
import study.racing.ResultView;
import study.racing.domain.Input;
import study.racing.domain.RacingHistory;
import study.racing.domain.Winner;
import study.racing.service.RacingGameService;
import study.racing.service.RacingGameWinnerService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

import java.util.List;

public class RacingGameWinner {

    public void racing() {
        InputView inputView = new InputView();
        Input input = inputView.readWinnerInput();

        RacingGameWinnerService racingGameWinnerService = new RacingGameWinnerService(input);
        RacingHistory racingHistory = racingGameWinnerService.raceStart(new MoveUnderOneDigitStrategy());
        List<Winner> winners = racingGameWinnerService.findWinners(racingHistory);

        ResultView resultView = new ResultView();
        resultView.printViewWinner(racingHistory,winners);
    }
}
