package domain;

import strategy.MovableStrategy;
import strategy.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cars {
    private final List<Car> cars = new ArrayList();
    private final NumberGeneratorStrategy numberGeneratorStrategy;

    public Cars(Set<String> players, MovableStrategy movableStrategy, NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
        for (String player : players) {
            cars.add(new Car(player, movableStrategy));
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
