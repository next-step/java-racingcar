package racingcar;

import racingcar.param.CarRacingInitParams;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class ConsoleController {

    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int totalRound = InputView.inputRound();
        CarRacingInitParams carRacingInitParams = CarRacingInitParams.of(totalRound, carNames);

        CarRacing carRacing = CarRacing.init(carRacingInitParams);

        ResultView.printResultStatement();

        while (!carRacing.isRaceOver()) {
            carRacing.race(RandomMoveStrategy.DEFAULT_MOVE_STRATEGY);
            ResultView.printState(carRacing.currentState());
        }

        ResultView.printWinners(carRacing.getLeaders());
    }
}
