package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.dto.RoundReady;
import racingcar.service.model.RoundResult;
import racingcar.service.strategy.RandomRoundRule;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.ui.model.RacingCarInputValue;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        RacingCarInputValue racingCarInputValue = inputView.getInputValue();
        RoundResult roundResult = startRound(racingCarInputValue);
        outputView.output(roundResult);
    }

    private RoundResult startRound(RacingCarInputValue racingCarInputValue) {
        RacingCarService racingCarService = RacingCarService.ready(RoundReady.of(new RandomRoundRule(),
                                                                                 racingCarInputValue.getCarNames(),
                                                                                 racingCarInputValue.getFinalRound()));
        return racingCarService.startRound();
    }
}
