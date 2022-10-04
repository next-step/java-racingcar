package carracing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(int numberOfCars) {
        if (numberOfCars < 0) {
            throw new IllegalArgumentException("자동차 대수는 0 또는 양수만 가능합니다.");
        }
        this.cars = new ArrayList<>();

        for (int index = 0; index < numberOfCars; index++) {
            this.cars.add(new Car());
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void goOrStop(MovableStrategy movableStrategy) {
        cars.forEach(car -> car.tryMove(movableStrategy));
    }

    public List<MoveResult> gatherMoveResults() {
        return cars.stream()
                   .map(Car::getMoveResult)
                   .collect(Collectors.toList());
    }
}
