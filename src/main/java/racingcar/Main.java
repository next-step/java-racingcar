package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        String[] carNames = InputView.inputCarNames();
        int gameRoundCount = InputView.inputGameRoundCount();

        RacingGame racingGame = new RacingGame(gameRoundCount, carNames);
        RacingGameResult racingGameResult = racingGame.play();

        ResultView.printBanner();
        ResultView.printResult(racingGameResult);
        ResultView.printWinner(racingGameResult.getWinner());
    }
}
