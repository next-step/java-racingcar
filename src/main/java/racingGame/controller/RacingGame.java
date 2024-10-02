package racingGame.controller;

import racingGame.model.car.Car;
import racingGame.service.RacingGameService;
import racingGame.ui.output.ConsoleOutputView;
import racingGame.ui.output.OutputView;

import java.util.List;

public class RacingGame {

    private static final int MINIMUM_MOVE_COUNT = 1;

    private static final String MOVE_COUNT_ERROR_MESSAGE = "최소 1회 이상은 입력해주세요!";

    private int moveCount;
    private int round;
    private final RacingGameService gameService;
    private final OutputView output;

    public RacingGame(int carCount, int moveCount) {
        validateMoveCount(moveCount);

        this.gameService = new RacingGameService(carCount);
        this.output = new ConsoleOutputView();
        this.moveCount = moveCount;
        this.round = 0;
    }

    public void play() {
        output.printInitMessage();
        while (round < moveCount) {
            List<Car> cars =  gameService.moveAllCars();
            output.printCarGraph(cars);
            round++;
        }
    }

    public int getRound() {
        return this.round;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < MINIMUM_MOVE_COUNT) {
            throw new IllegalArgumentException(MOVE_COUNT_ERROR_MESSAGE);
        }
    }
}
