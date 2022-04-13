package racing.domain;

import racing.domain.strategies.CarMoveStrategy;
import racing.dto.GameResult.GameRoundResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> nameOfCars) {
        cars = nameOfCars.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public GameRoundResult run(CarMoveStrategy moveStrategy) {
        GameRoundResult round = new GameRoundResult();
        cars.stream()
                .map(car -> car.run(moveStrategy))
                .forEach(round::addResult);
        return round;
    }
}
