package racingcar.domain;

import java.util.Iterator;

public class CarsIterator implements Iterator {

    private final Cars cars;
    private int index;

    public CarsIterator(Cars cars) {
        this.cars = cars;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return cars.hasNextCar(index);
    }

    @Override
    public Car next() {
        return cars.get(index++);
    }
}
