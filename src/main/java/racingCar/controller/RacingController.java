package racingCar.controller;

import racingCar.domain.PlayerGroup;
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
        PlayerGroup.from(inputView.inputPlayer());
    }
}
