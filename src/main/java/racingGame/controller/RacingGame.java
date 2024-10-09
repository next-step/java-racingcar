package racingGame.controller;

import racingGame.model.car.Car;
import racingGame.model.car.CarMovement;
import racingGame.model.car.Cars;
import racingGame.model.car.TryNo;
import racingGame.service.RacingGameService;
import racingGame.ui.input.InputView;
import racingGame.ui.output.OutputView;

import java.util.List;

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
        Cars cars = Cars.toCars(input.getCarNames());
        TryNo round = new TryNo(input.getMoveCount(), gameService);

        output.printInitMessage();

        CarMovement carMovement = round.tryForRounds(cars);
        List<Car> winners = gameService.findWinners(carMovement.getFinalCarState());

        output.printCarGraph(carMovement);
        output.printWinners(winners);
    }

}
