package step3.game.controller;

import step3.game.domain.car.CarName;
import step3.game.domain.PositiveNumber;
import step3.game.domain.RacingCarGame;
import step3.view.input.ConsoleInputView;
import step3.view.input.InputView;
import step3.view.output.OutputView;

import java.util.Set;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Set<CarName> carNames = inputView.carNames();
        PositiveNumber tryCount = inputView.tryCount();

        RacingCarGame racingGame = new RacingCarGame(carNames, tryCount);

        outputView.result();
        for (int turn = 0; turn < tryCount.number; turn++) {
            racingGame.takeTurn();
            outputView.endOfThisTurn(racingGame.getCars());
        }

        outputView.finalResult(racingGame.getCars());
        ConsoleInputView.closeScanner();
    }
}
