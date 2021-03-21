package racingcar.domain;

import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carNumber) {
        this.cars = generateCars(carNumber);
    }

    public Cars(Cars cars) {
        this.cars = deepCopyCars(cars);
    }

    private List<Car> deepCopyCars(Cars cars) {
        List<Car> copiedCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            copiedCars.add(new Car(car));
        }
        return copiedCars;
    }

    private List<Car> generateCars(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (int i = 0; i < getSize(); i++) {
            this.cars.get(i).move(moveStrategy.getIsMove());
        }
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }


}


