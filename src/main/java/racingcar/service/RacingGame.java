package racingcar.service;

import racingcar.dto.Board;
import racingcar.model.Cars;
import racingcar.dto.RacingInfo;
import racingcar.strategy.MovingStrategy;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

public class RacingGame {
    private final RacingInfo racingInfo;
    private final Cars cars;
    private Board board;

    public RacingGame(RacingInfo racingInfo, Cars cars) {
        this.racingInfo = racingInfo;
        this.cars = cars;
        this.board = new Board();
    }

    public Board gameStart(MovingStrategy movingStrategy) {
        for (int i = 0; i < racingInfo.raceTrialCount; i++) {
            cars.move(movingStrategy);
            board.record(cars.getCarsPositions());
        }
        return board;
    }
}
