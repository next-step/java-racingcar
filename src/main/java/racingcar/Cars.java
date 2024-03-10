package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(int input) {
        cars = new ArrayList<>();
        for (int i=0; i < input; i++) {
            cars.add(new Car());
        }
    }

    public int size() {
        return this.cars.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

}
