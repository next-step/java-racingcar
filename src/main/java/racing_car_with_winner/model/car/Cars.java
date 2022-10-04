package racing_car_with_winner.model.car;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import racing_car_with_winner.model.MovableStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars moveCars(MovableStrategy movableStrategy) {
        List<Car> movedCars = cars.stream()
                                  .map(car -> car.tryMove(movableStrategy))
                                  .collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public List<Car> findWinner() {
        Map<MoveResult, List<Car>> groupByMoveResult = this.cars.stream()
                                                                .collect(Collectors.groupingBy(Car::getMoveResult));

        MoveResult winnerResult = groupByMoveResult.keySet().stream()
                                                   .max(Comparator.comparingInt(MoveResult::getMoveCount))
                                                   .orElseThrow(() -> new IllegalArgumentException("우승자가 존재하지 않습니다"));

        return groupByMoveResult.get(winnerResult);
    }
}
