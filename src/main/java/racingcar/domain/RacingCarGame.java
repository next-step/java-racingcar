package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final Comparator<Car> CAR_POSITION_COMPARATOR = Comparator.comparing(Car::getPosition);
    private final List<Car> cars;
    private int rounds;
    private final MoveStrategy moveStrategy;

    public RacingCarGame(List<Car> cars, int rounds, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.rounds = rounds;
        this.moveStrategy = moveStrategy;
    }

    public void proceedRound() {
        decreaseGameRound();
        cars.forEach(car -> car.move(moveStrategy));
    }

    private void decreaseGameRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }

        rounds = rounds - 1;
    }

    public GameResult getResult() {
        if (rounds > 0) {
            throw new IllegalStateException("game is still on progress");
        }

        return new GameResult(findWinners());
    }

    private List<Car> findWinners() {
        Car winner = cars.stream()
                .max(CAR_POSITION_COMPARATOR)
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(c -> c.getPosition() == winner.getPosition())
                .collect(Collectors.toList());
    }

}
