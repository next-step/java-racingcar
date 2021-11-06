package racingcar.controller;

import racingcar.controller.convert.RacingCarOutputConverter;
import racingcar.controller.model.RacingCarInput;
import racingcar.service.RacingCarService;
import racingcar.service.dto.RoundReady;
import racingcar.service.dto.RoundResult;
import racingcar.service.strategy.RandomRoundRule;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        RacingCarInput racingCarInput = inputView.getInputValue();
        RoundResult roundResult = startRound(racingCarInput);
        outputView.output(RacingCarOutputConverter.convert(roundResult));
    }

    private RoundResult startRound(RacingCarInput racingCarInput) {
        RacingCarService racingCarService = RacingCarService.ready(RoundReady.of(new RandomRoundRule(),
                                                                                 racingCarInput.getCarNames(),
                                                                                 racingCarInput.getFinalRound()));
        return racingCarService.startRound();
    }
}
