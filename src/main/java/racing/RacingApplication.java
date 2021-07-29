package racing;

import racing.view.InputView;


public class RacingApplication {

    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int gameCount = InputView.getGameCount();
        RacingGame racingGame = new RacingGame();
        racingGame.gameStart(carNames, gameCount);
    }

}
