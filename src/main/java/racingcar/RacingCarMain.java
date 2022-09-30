package racingcar;

import racingcar.ui.InputView;

public class RacingCarMain {
    public static void main(String[] args) {

        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();

        RacingCarGame racingCarGame = new RacingCarGame(carCount, tryCount);
        racingCarGame.play();

    }
}
