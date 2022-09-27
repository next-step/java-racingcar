package racingcar;

import racingcar.view.InputView;

public class RacingCarGameFactory {

    public static RacingCarGame getInstance() {
        int carCount = InputView.getCarCount();
        int playCount = InputView.getPlayCount();
        return new RacingCarGame(carCount, playCount);
    }
}
