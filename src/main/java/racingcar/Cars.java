package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private final List<Car> cars = new ArrayList<>();

    public Cars(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
