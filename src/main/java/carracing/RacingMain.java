package carracing;

import carracing.domain.RacingGame;
import carracing.views.InputView;
import carracing.views.ResultView;

public class RacingMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        String carCount = inputView.getCarCount();
        int tryCount = inputView.getTryCount();

        RacingGame racingGame = new RacingGame(0, tryCount);

        while (racingGame.remainTryCount()) {
            racingGame.racing();
            resultView.showRacingPosition(racingGame);
        }
    }
}
