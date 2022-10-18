package carracing;

import carracing.domain.RacingGame;
import carracing.views.InputView;
import carracing.views.ResultView;

public class RacingMain {
    private static InputView inputView = new InputView();
    private static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int carCount = inputView.getCarCount();
        int tryCount = inputView.getTryCount();

        RacingGame racingGame = new RacingGame(carCount, tryCount);

        while (racingGame.remainTryCount()) {
            racingGame.racing();
            resultView.showRacingPosition(racingGame);
        }
    }
}
