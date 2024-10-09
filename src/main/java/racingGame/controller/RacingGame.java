package racingGame.controller;

import racingGame.model.car.CarMovement;
import racingGame.model.car.TryNo;
import racingGame.service.RacingGameService;
import racingGame.ui.input.InputView;
import racingGame.ui.output.OutputView;

public class RacingGame {

    private final RacingGameService gameService;
    private final InputView input;
    private final OutputView output;

    public RacingGame(InputView input, OutputView output, RacingGameService gameService) {
        this.input = input;
        this.output = output;
        this.gameService = gameService;
    }

    public void play() {
        int carCount = input.getCarCount();
        TryNo round = new TryNo(input.getMoveCount(), gameService);

        output.printInitMessage();
        CarMovement carMovement = round.tryForRounds(carCount);
        output.printCarGraph(carMovement);
    }

}
