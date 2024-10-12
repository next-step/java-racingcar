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
        Cars cars = Cars.newInstance(input.getCarNames());
        int round = input.getMoveCount();

        output.printInitMessage();

        CarMovement carMovement = gameService.moveCarsForAllRounds(cars, round);

        List<Car> winners = gameService.findWinners(carMovement.getFinalCarState());

        output.printCarGraph(carMovement);
        output.printWinners(winners);
    }

}
