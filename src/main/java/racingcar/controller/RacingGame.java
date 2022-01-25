package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.car.RandomEngine;
import racingcar.domain.Round;
import racingcar.domain.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.utils.StringUtils;

public class RacingGame {

    private Cars cars;
    private Round round;

    public RacingGame() {
    }

    public void run() {
        setUpGame();
        while (round.untilEnd()) {
            cars.moveAll();
            OutputView.showResult(cars.cars());
        }
        Winners winners = Winners.findWinners(cars.cars());
        OutputView.showWinners(winners.winners());
    }

    private void setUpGame() {
        String carNames = InputView.getCarNames();
        String[] splitCarNames = StringUtils.splitCarNames(carNames);
        cars = new Cars(splitCarNames, new RandomEngine());
        String inputRound = InputView.getRound();
        round = new Round(inputRound);
    }
}
