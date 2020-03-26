package step3.domain;

import java.util.Iterator;

public class CarsIterator implements Iterator {

    private Cars cars;
    private int index;

    public CarsIterator(Cars cars) {
        this.cars = cars;
        this.index = 0;
    }

    public boolean hasNext() {
        if(index < cars.getCarsLength()) {
            return true;
        }
        return false;
    }

    public Car next() {
        Car car = cars.getCar(index);
        index++;
        return car;
    }

}
