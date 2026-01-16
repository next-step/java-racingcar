package carracing;

import carracing.domain.RacingGame;
import carracing.domain.RacingResult;
import carracing.domain.RandomNumberGenerator;
import carracing.view.InputView;
import carracing.view.ResultView;

public class Main {
    public static void main(String[] args) {
        String carNames = InputView.initCarInfo();
        int tryCount = InputView.initTryCount();
        RacingGame racingGame = new RacingGame(carNames, tryCount);

        RacingResult result = null;
        while (racingGame.isEnd()) {
            result = racingGame.play(new RandomNumberGenerator());
            ResultView.printResult(result);
        }

        ResultView.printWinners(result);
    }
}
