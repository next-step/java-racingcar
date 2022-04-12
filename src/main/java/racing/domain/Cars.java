package racing.domain;

import racing.domain.strategies.CarMoveStrategy;
import racing.dto.GameResult.GameRoundResult;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public GameRoundResult run(CarMoveStrategy moveStrategy) {
        GameRoundResult round = new GameRoundResult();
        cars.stream()
                .map(car -> car.run(moveStrategy))
                .forEach(round::addResult);
        return round;
    }
}
