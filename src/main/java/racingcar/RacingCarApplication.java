package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NormalMoveStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        // 입력
        String[] carNames = inputView.askCarNames();
        int numberOfTrials = inputView.askTrialCount();

        // 경주
        RacingCars racingCars = new RacingCars(carNames);
        Racing racing = new Racing(racingCars);
        MoveStrategy normalMoveStrategy = new NormalMoveStrategy();
        ResultView resultView = new ResultView();

        // 출력
        resultView.printResultTitle();

        for (int i = 0; i < numberOfTrials; i++) {
            racing.startRacingRound(normalMoveStrategy);
            resultView.printRacingRound(racing.statusOfRacing());
        }

        resultView.printGameWinner(racing.statusOfRacing());
    }
}