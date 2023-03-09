package car.domain;

import car.domain.strategy.RacingGameStrategy;
import car.ui.GameResult;
import car.ui.Winner;

import java.util.List;

public class RacingGame {
    private final RacingGameStrategy racingGameStrategy;
    private final Cars cars;

    public RacingGame(RacingGameStrategy racingGameStrategy, Cars cars) {
        this.racingGameStrategy = racingGameStrategy;
        this.cars = cars;
    }

    public GameResult<List<Winner>> play(final int moveCount) {

        validateMoveCount(moveCount);

        for (int i = 0; i < moveCount; i++) {
            racingGameStrategy.apply(cars);
        }

        cars.printPositionInfo();

        List<Winner> winners = cars.getWinners();
        System.out.println("최종 우승자: " + winners);
        return new GameResult(winners.size(), winners);
    }


    private void validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동횟수는 1 이상이어야 합니다. moveCount: " + moveCount);
        }
    }
}
