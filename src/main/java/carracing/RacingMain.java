package carracing;

import carracing.domain.RacingGame;
import carracing.views.InputView;
import carracing.views.ResultView;

import java.util.List;

public class RacingMain {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        List<String> nameList = inputView.getCarNames();
        int tryCount = inputView.getTryCount();

        RacingGame racingGame = new RacingGame(nameList, tryCount);

        while (racingGame.remainTryCount()) {
            racingGame.racing();
            resultView.showRacingPosition(racingGame);
        }

    }
}
