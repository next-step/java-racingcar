package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {

    private static final int START_FROM_ZERO = 0;

    private final RacingService racingService;
    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(final RacingService racingService, final InputView inputView,
        final ResultView resultView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void setUpRacing() {
        inputView.processConsoleInput();
        racingService.registerCars(inputView.getSplitUserInput());
    }

    public void startRacing() {
        for (int time = START_FROM_ZERO; time < inputView.getRacingTime(); time++) {
            racingService.drive();
        }
        resultView.announceRacingDetails(racingService.getMovingResult());
    }

    public String finishRacing() {
        return resultView.announceWinner(racingService.judgeWinners());
    }

}
