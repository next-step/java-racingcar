package racingcar.controller;

import racingcar.domain.GameInputData;
import racingcar.domain.GameResultData;
import racingcar.service.RacingGameService;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarResultView;

public class RacingCarController {

    private final RacingCarInputView inputView;

    public RacingCarController(RacingCarInputView inputView) {

        this.inputView = inputView;
    }

    public void execute() {

        GameInputData racingCarInput = inputView.getRacingCarInput();
        RacingGameService start = RacingGameService.ready(racingCarInput.getCarNames());

        GameResultData result = start.execute(racingCarInput);

        RacingCarResultView resultView = new RacingCarResultView();
        resultView.output(result);
    }
}
