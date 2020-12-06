package step4.domain;

import step4.domain.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(int numOfCar) {
        this.cars = new ArrayList<>();
        addCars(numOfCar);
    }

    public void moveCars(MovingStrategy movingStrategy) {
        cars.stream()
                .forEach(car -> car.move(movingStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }

    private void addCars(int numOfCar) {
        for (int i = 0; i< numOfCar; i++) {
            cars.add(new Car());
        }
    }
}
