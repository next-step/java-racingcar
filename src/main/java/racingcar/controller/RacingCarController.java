package racingcar.controller;

import racingcar.domain.GameInputData;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;

public class RacingCarController {

    private final InputView inputView;


    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void execute() {

        GameInputData racingCarInput = inputView.getRacingCarInput();
        RacingGameService start = RacingGameService.ready(racingCarInput.getCarCount());

        start.execute(racingCarInput);
    }
}
