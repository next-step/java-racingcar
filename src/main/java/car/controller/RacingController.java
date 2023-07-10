package car.controller;

import static car.view.input.InputView.enterCarName;
import static car.view.input.InputView.enterCount;
import static car.view.output.OutputView.printEachRaceResult;
import static car.view.output.OutputView.printExecuteResult;
import static car.view.output.OutputView.printWinner;

import car.model.RacingGame;

public final class RacingController {

    private final RacingGame racingGame;

    public RacingController(final RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public RacingController() {
        this.racingGame = new RacingGame(enterCarName(), enterCount());
    }

    public void start() {
        printExecuteResult();

        while (racingGame.isLeftRound()) {
            racingGame.runRaceOnce();
            printEachRaceResult(racingGame.createCarResult());
        }

        printEachRaceResult(racingGame.createCarResult());
        printWinner(racingGame.selectWinner());
    }
}
