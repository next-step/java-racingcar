package racingGame.controller;

import racingGame.model.car.CarMovement;
import racingGame.model.car.TryNo;
import racingGame.service.RacingGameService;
import racingGame.ui.input.ConsoleInputView;
import racingGame.ui.input.InputView;
import racingGame.ui.output.ConsoleOutputView;
import racingGame.ui.output.OutputView;

public class RacingGame {

    private final RacingGameService gameService = new RacingGameService();
    private final InputView input = new ConsoleInputView();
    private final OutputView output = new ConsoleOutputView();

    public RacingGame() {}

    public void play() {
        int carCount = input.getCarCount();
        TryNo moveCount = new TryNo(input.getMoveCount());

        output.printInitMessage();
        CarMovement carMovement = gameService.moveCarsForAllRounds(carCount, moveCount);
        output.printCarGraph(carMovement);
    }

}
