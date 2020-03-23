package study.racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private List<Car> winner;

    public RacingGameResult(RacingGame racingGame) {
        if (!racingGame.isFinished()) {
            throw new IllegalArgumentException("종료된 게임이 아닙니다.");
        }

        winner = getWinner(racingGame.getCars());
    }

    private List<Car> getWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.isPositionEqualTo(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return Collections
                .max(cars, Comparator.comparing(Car::getPosition))
                .getPosition();
    }

    public List<Car> getWinner() {
        return winner;
    }
}
