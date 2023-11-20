package racingCar.controller;

import racingCar.domain.PlayerGroup;
import racingCar.domain.TryCount;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PlayerGroup playerGroup = PlayerGroup.from(inputView.inputPlayer());
        TryCount tryCount = TryCount.from(inputView.inputTryCount());
    }
}
