package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    Cars(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
        this.cars = cars;
    }

    Cars(List<Car> cars) {
        this.cars = cars;
    }

    Cars moveAllCar(MoveStrategy moveStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move(moveStrategy.isMove());
            movedCars.add(movedCar);
        }
        return new Cars(movedCars);
    }

    boolean hasNextCar(int index) {
        return cars.size() != index;
    }

    Car getCar(int index) {
        return new Car(cars.get(index));
    }

    @Override
    public String toString() {
        return cars.toString();
    }
}
