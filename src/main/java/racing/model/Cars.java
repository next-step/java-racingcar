package racing.model;

import racing.model.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;
    private MoveStrategy moveStrategy;

    public Cars(int number, MoveStrategy moveStrategy) {
        cars = new ArrayList<>();
        createCars(number);
        this.moveStrategy = moveStrategy;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(int number) {
        for (int i = 0; i < number; i++) {
            cars.add(new Car());
        }

        return cars;
    }
}
