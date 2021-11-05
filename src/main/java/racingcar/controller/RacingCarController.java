package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.dto.RoundReadyDTO;
import racingcar.service.dto.RoundResultDTO;
import racingcar.service.strategy.RandomRoundRule;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.ui.RacingCarInputView;
import racingcar.ui.ResultCarOutputView;
import racingcar.ui.model.RacingCarInputValue;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        inputView = new RacingCarInputView();
        outputView = new ResultCarOutputView();
    }

    public void execute() {
        RacingCarInputValue racingCarInputValue = inputView.getInputValue();
        RoundResultDTO roundResult = startRound(racingCarInputValue);
        outputView.output(roundResult);
    }

    private RoundResultDTO startRound(RacingCarInputValue racingCarInputValue) {
        RacingCarService racingCarService = RacingCarService.ready(RoundReadyDTO.of(new RandomRoundRule(),
                                                                                    racingCarInputValue.getCarNames(),
                                                                                    racingCarInputValue.getTotalRaceCount()));
        return racingCarService.startRound();
    }
}
