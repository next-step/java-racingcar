package game.domain;

import game.domain.movable.MovableStrategy;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> cars) {
        this.carList = cars;
    }

    public void moveCarList(final MovableStrategy movableStrategy) {
        for (Car v : this.carList) {
            v.move(movableStrategy);
        }
    }

    public boolean contains(Car car) {
        return this.carList.contains(car);
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }
}
