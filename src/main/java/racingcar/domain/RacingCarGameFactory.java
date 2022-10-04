package racingcar.domain;

import racingcar.view.InputView;

public class RacingCarGameFactory {

    public static RacingCarGame getInstance() {
        String[] carNames = InputView.getCarNames();
        int playCount = InputView.getPlayCount();
        return new RacingCarGame(carNames, playCount);
    }
}
