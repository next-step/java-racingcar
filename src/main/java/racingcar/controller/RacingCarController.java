package racingcar.controller;

import racingcar.domain.GameInputData;
import racingcar.service.RacingGameService;
import racingcar.view.RacingCarInputView;

public class RacingCarController {

    private final RacingCarInputView inputView;

    public RacingCarController(RacingCarInputView inputView) {

        this.inputView = inputView;
    }

    public void execute() {

        GameInputData racingCarInput = inputView.getRacingCarInput();
        RacingGameService start = RacingGameService.ready(racingCarInput.getCarNames());

        start.execute(racingCarInput);
    }
}
