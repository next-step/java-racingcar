package carracing;

import carracing.move_strategy.MoveStrategy;

import java.util.List;

public class CarRace {
    private final Cars cars;

    public CarRace(Cars cars) {
        this.cars = cars;
    }

    public void run(MoveStrategy moveStrategy) {
        cars.move(moveStrategy.getMovePoint());
    }

    public List<Car> winners() {
        return cars.getFastestCars();
    }

    public Cars carHistory() {
        return this.cars;
    }
}
