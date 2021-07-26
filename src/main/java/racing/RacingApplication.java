package racing;

import racing.view.InputView;


public class RacingApplication {

    public static void main(String[] args) {

        int carSize = InputView.getCarSize();
        int gameCount = InputView.getGameCount();
        Racing racing = new Racing();
        racing.gameStart(carSize, gameCount);
    }

}
