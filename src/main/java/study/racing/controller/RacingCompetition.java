package study.racing.controller;

import study.racing.InputView;
import study.racing.ResultView;
import study.racing.domain.Car;
import study.racing.domain.CarRaceInput;
import study.racing.domain.RacingHistory;
import study.racing.service.RacingGameWinnerService;
import study.racing.strategy.MoveUnderOneDigitStrategy;

import java.util.List;

public class RacingCompetition {

    public void racing() {
        InputView inputView = new InputView();
        CarRaceInput carRaceInput = inputView.collectUserInput();

        RacingGameWinnerService racingGameWinnerService = new RacingGameWinnerService();
        RacingHistory racingHistory = racingGameWinnerService.raceStart(carRaceInput, new MoveUnderOneDigitStrategy());
        List<Car> winners = racingGameWinnerService.findWinners(carRaceInput.getCarCount(), racingHistory);

        ResultView resultView = new ResultView();
        resultView.printRacingHistory(racingHistory);
        resultView.printWinner(winners);
    }
}
