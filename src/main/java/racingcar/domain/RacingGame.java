package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.movingcondition.MovingCondition;

public class RacingGame {
    private final List<Car> cars;
    private final MovingCondition movingCondition;
    private int remainPlayCount;

    public RacingGame(List<Car> cars, MovingCondition movingCondition, int playCount) {
        this.cars = cars;
        this.movingCondition = movingCondition;
        this.remainPlayCount = playCount;
    }

    public boolean isGameEnd() {
        return remainPlayCount <= 0;
    }

    public List<Integer> play() {
        if (!isGameEnd()) {
            return playNextRound();
        }

        return List.of();
    }

    private List<Integer> playNextRound() {
        remainPlayCount--;
        List<Integer> result = new ArrayList<>();

        for (Car car : cars) {
            result.add(car.move(movingCondition));
        }

        return result;
    }
}
