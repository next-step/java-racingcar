package domain;

import strategy.MovableStrategy;
import strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList();
    private final NumberGeneratorStrategy numberGeneratorStrategy;

    public Cars(int numberOfCar, MovableStrategy movableStrategy, NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
        for (int i = 0; i < numberOfCar; i++) {
            cars.add(new Car(movableStrategy));
        }
    }

    public void race() {
        for (Car car : cars) {
            car.move(numberGeneratorStrategy.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
