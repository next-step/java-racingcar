package racingcar;

import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.askCarNames();
        RacingCars racingCars = new RacingCars(carNames);

        int numberOfTrials = inputView.askTrialCount();

        MoveStrategy normalMoveStrategy = new RandomMoveStrategy();

        ResultView resultView = new ResultView();
        resultView.printResultTitle();

        for (int i = 0; i < numberOfTrials; i++) {
            racingCars.runRacingRound(normalMoveStrategy);
            resultView.printRacingRound(racingCars.statusOfRacingCars());
        }

        resultView.printGameWinner(racingCars.statusOfRacingCars());
    }
}