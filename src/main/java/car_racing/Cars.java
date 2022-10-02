package car_racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(int numberOfCars) {
        this.cars = new ArrayList<>();

        for (int index = 0; index < numberOfCars; index++) {
            this.cars.add(new Car());
        }
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
