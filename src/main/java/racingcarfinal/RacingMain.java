package racingcarfinal;

import racingcarfinal.domain.RacingGame;
import racingcarfinal.ui.InputView;
import racingcarfinal.ui.ResultView;

public class RacingMain {

    public static void main(String[] args) {
        String carNames = InputView.readCarNames();
        int tryCount = InputView.readTryCount();

        RacingGame game = new RacingGame(carNames, tryCount);

        ResultView.printResultsMessage();
        while (!game.isEnd()) {
            game.play();
            ResultView.printOneRoundResult(game.getCars());
        }
        ResultView.printWinners(game.findWinners());

    }

}
