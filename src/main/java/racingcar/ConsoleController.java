package racingcar;

import racingcar.param.RacingCarInitParam;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class ConsoleController {

    public static void main(String[] args) {
        int numberOfCars = InputView.inputNumberOfCars();
        int totalRound = InputView.inputRound();
        RacingCarInitParam racingCarInitParam = RacingCarInitParam.of(numberOfCars, totalRound);

        RacingCar racingCar = RacingCar.init(racingCarInitParam, RandomMoveStrategy.DEFAULT_MOVE_STRATEGY);

        ResultView.printResultStatement();
        ResultView.printState(racingCar.currentState());

        while (!racingCar.isRaceOver()) {
            racingCar.race();
            ResultView.printState(racingCar.currentState());
        }
    }
}
