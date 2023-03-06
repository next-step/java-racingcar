package car.domain;

import car.domain.condition.RacingGameStrategy;
import car.ui.GameResult;
import car.ui.Winner;

import java.util.List;

public class RacingGame {
    private final RacingGameStrategy racingCondition;
    private final Cars cars;

    public RacingGame(RacingGameStrategy racingCondition, Cars cars) {
        this.racingCondition = racingCondition;
        this.cars = cars;
    }

    public GameResult<List<Winner>> play(final int moveCount) {

        for (int i = 0; i < moveCount; i++) {
            racingCondition.apply(cars);
        }

        List<Winner> winners = cars.getWinners();
        System.out.println("최종 우승자: " + winners);
        GameResult<List<Winner>> result = new GameResult(winners.size(), winners);
        return result;
    }
}
