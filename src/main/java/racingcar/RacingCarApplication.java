package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.strategyTest.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;


public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.askCarNames();
        RacingCars racingCars = new RacingCars(carNames);
        Racing racing = new Racing();

        int numberOfTrials = inputView.askTrialCount();

        ResultView resultView = new ResultView();

        resultView.printResultTitle();

        for (int i = 0; i < numberOfTrials; i++) {
            racing.runRacingRound(racingCars.statusOfRacingCars(), new RandomMoveStrategy());
            resultView.printRacingRound(racingCars.statusOfRacingCars());
        }

        resultView.printGameWinner(racing.makeWinnerList(racingCars.statusOfRacingCars()));
    }
}