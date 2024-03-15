package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;
import racingcar.domain.strategyPattern.StrategyRandomMove;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private static final StrategyRandomMove strategyRandomMove = new StrategyRandomMove();

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int trialCount = InputView.inputTrialCount();

        RacingCarGame racingCarGame = new RacingCarGame(carCount, trialCount);
        List<List<Car>> result = racingCarGame.playRounds(trialCount, strategyRandomMove);

        OutputView.printCarsPositionByRounds(result);
    }
}
