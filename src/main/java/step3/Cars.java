package step3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars = new ArrayList<>();

    public Cars(int numberOfCar, MovableStrategy movableStrategy) {
        for (int i = 0; i < numberOfCar; i++) {
            Car car = new Car(movableStrategy);
            this.cars.add(car);
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }
}
