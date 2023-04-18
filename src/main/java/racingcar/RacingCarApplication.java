package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        String[] carNames = inputView.askCarNames();
        RacingCars racingCars = new RacingCars(carNames);
        Racing racing = new Racing(racingCars.statusOfRacingCars());

        int numberOfTrials = inputView.askTrialCount();

        ResultView resultView = new ResultView();
        resultView.printResultTitle();

        for (int i = 0; i < numberOfTrials; i++) {
            racing.runRacingRound(new RandomMoveStrategy());
            resultView.printRacingRound(racingCars.statusOfRacingCars());
        }


        List<String> gameWinner = racing.makeWinnerList();

        resultView.printGameWinner(gameWinner);
    }
}