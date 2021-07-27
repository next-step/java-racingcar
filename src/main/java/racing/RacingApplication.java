package racing;

import racing.view.InputView;


public class RacingApplication {

    public static void main(String[] args) {
        int carSize = InputView.getCarSize();
        int gameCount = InputView.getGameCount();
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart(carSize, gameCount);
    }

}
