package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Main {

    public static void main(String[] args) {

        String[] carNames = InputView.getCarNames();
        int gameRound = InputView.getGameRound();

        RacingGame racingGame = new RacingGame(gameRound, carNames);
        RacingGameResult racingGameResult = racingGame.play();

        ResultView.printBanner();
        ResultView.printResult(racingGameResult);
        ResultView.printWinner(racingGameResult.getWinner());
    }
}
