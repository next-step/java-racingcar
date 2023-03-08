package car.domain;

import car.domain.condition.RacingGameStrategy;
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

        for (int i = 0; i < moveCount; i++) {
            racingGameStrategy.apply(cars);
        }

        List<Winner> winners = cars.getWinners();
        System.out.println("최종 우승자: " + winners);
        return new GameResult(winners.size(), winners);
    }
}
