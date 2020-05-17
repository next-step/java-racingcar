package racingcar.domain.car;

import racingcar.domain.car.strategy.MovementStrategy;
import racingcar.vo.car.CarMoveResult;

import java.util.ArrayList;
import java.util.List;

public class ParticipateCars {
    private List<Car> cars;

    public ParticipateCars(String[] nameOfCars) {
        this.cars = createCars(nameOfCars);
    }

    private List<Car> createCars(String[] nameOfCars) {
        validateNamesSize(nameOfCars);
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < nameOfCars.length; i++) {
            cars.add(new Car(nameOfCars[i]));
        }

        return cars;
    }

    public List<CarMoveResult> moveCars(MovementStrategy movementStrategy) {
        List<CarMoveResult> carMoveResults = new ArrayList<>();

        for (Car car : cars) {
            int afterLocation = car.move(movementStrategy);
            carMoveResults.add(new CarMoveResult(car.getName(), afterLocation));
        }

        return carMoveResults;
    }

    private void validateNamesSize(String[] names) {
        if (names.length == 0) {
            throw new IllegalStateException("이름이 입력되지 않았습니다.");
        }
    }
}
