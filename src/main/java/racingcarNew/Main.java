package racingcarNew;

import racingcarNew.domain.RacingHistory;
import racingcarNew.view.InputView;
import racingcarNew.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.carNames();
        int racingLap = inputView.racingLap();

        RacingGame racingGame = new RacingGame(carNames, racingLap);

        RacingHistory racingHistory = racingGame.race();

        ResultView resultView = new ResultView(racingHistory);
        resultView.printRacingHistory();
        resultView.printStatistic(racingLap);

    }

}
