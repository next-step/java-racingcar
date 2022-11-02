package carracing;

import carracing.domain.Cars;
import carracing.domain.RacingGame;
import carracing.views.InputView;
import carracing.views.ResultView;

public class RacingMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        Cars cars = new Cars(inputView.getCarNames());
        int tryCount = inputView.getTryCount();

        RacingGame racingGame = new RacingGame(cars, tryCount);

        while (racingGame.remainTryCount()) {
            racingGame.racing();
            resultView.showRacingPosition(racingGame);
        }
        racingGame.getWinners();
        resultView.showWinners(racingGame);
    }
}
