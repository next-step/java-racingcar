package racingcar.controller;

import java.util.List;
import racingcar.domain.DrivingStrategy;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameConsole {

    private final InputView inputView;
    private final OutputView outputView;
    private final DrivingStrategy drivingStrategy;

    public RacingGameConsole(
        InputView inputView, OutputView outputView, DrivingStrategy drivingStrategy
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.drivingStrategy = drivingStrategy;
    }

    public void start() {
        List<String> carNames = inputView.inputCarNames();
        int round = inputView.inputRound();

        startGame(carNames, round);
    }

    private void startGame(List<String> carNames, int round) {
        RacingGame racingGame = new RacingGame(carNames);
        racingGame.drive(round, drivingStrategy);

        outputView.printResult(racingGame);
        outputView.printWinners(racingGame);
    }
}
