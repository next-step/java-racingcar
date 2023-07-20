package study.racinggame.domain;

import study.racinggame.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final Cars cars;
    private final MoveStrategy moveStrategy;
    private final int gameCount;
    private int currentRound;
    private int maxPosition;

    public RaceGame(Cars cars, int gameCount, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.gameCount = gameCount;
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        for (Car car : cars.getCars()) {
            car.move(moveStrategy);
            Position position = car.getPosition();
            maxPosition = position.isHigherPosition(maxPosition) ? position.getPosition() : maxPosition;
        }
        currentRound++;
    }

    public boolean isEndGame() {
        return currentRound >= gameCount;
    }

    public List<Car> winners() {
        List<Car> winners = new ArrayList<>();
        cars.getCars().forEach((car) -> {
            if (car.getPosition().isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        });
        return winners;
    }
}
