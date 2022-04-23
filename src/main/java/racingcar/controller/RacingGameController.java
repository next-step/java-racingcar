package racingcar.controller;

import racingcar.model.PositiveNumber;
import racingcar.model.RacingGame;
import racingcar.pattern.ValueGenerateStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final ValueGenerateStrategy valueGenerateStrategy;

    public RacingGameController(ValueGenerateStrategy valueGenerateStrategy) {
        this.valueGenerateStrategy = valueGenerateStrategy;
    }

    public void gameStart() {
        String carNameText = InputView.carNames();
        PositiveNumber trialNumber = new PositiveNumber(InputView.trialNumber());

        OutputView.guide();
        racingCarGame(carNameText, trialNumber);
    }

    private void racingCarGame(String carNameText, PositiveNumber trialNumber) {
        RacingGame racingGame = new RacingGame(carNameText, trialNumber);

        while (!racingGame.isRacingDone()) {
            racingGame.racing(valueGenerateStrategy);
            OutputView.printRacingResult(racingGame.getCarMap());
        }
        OutputView.printWinners(racingGame.getWinners());
    }
}
