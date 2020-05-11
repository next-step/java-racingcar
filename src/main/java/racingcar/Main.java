package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;


public class Main {

    public static void main(String[] args) {

        int carCount = InputView.getCarCount();
        int gameRound = InputView.getGameRound();

        RacingGame racingGame = new RacingGame(carCount, gameRound);

        ResultView.printBanner();
        racingGame.play();
    }
}
