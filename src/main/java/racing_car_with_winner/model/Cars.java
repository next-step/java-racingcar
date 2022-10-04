package racing_car_with_winner.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    @Deprecated
    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();

        for (String carName : carNames) {
            this.cars.add(new Car(new CarName(carName)));
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars moveCars(MovableStrategy movableStrategy) {
        List<Car> movedCars = cars.stream().map(car -> car.tryMove(movableStrategy)).collect(Collectors.toList());

        return new Cars(movedCars);
    }

    public List<MoveResult> gatherResults() {
        return cars.stream()
                   .map(Car::getMoveResult)
                   .collect(Collectors.toList());
    }
}
