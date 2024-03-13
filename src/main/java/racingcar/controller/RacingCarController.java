package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.domain.strategyPattern.StrategyRandomMove;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int trialCount = InputView.inputTrialCount();

        RacingCarGame racingCarGame = new RacingCarGame(carCount);

        System.out.println("실행 결과");
        while (trialCount-- > 0) {
            OutputView.printCarPositionByPeriod(racingCarGame.playRoundsAndReturnCarList(new StrategyRandomMove()));
        }
    }
}
