package racingStep3.controller;

import racingStep3.domain.GameInputData;
import racingStep3.service.RacingGameService;
import racingStep3.view.InputView;

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
