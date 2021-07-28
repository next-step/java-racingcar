package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private List<Car> cars = new ArrayList<>();

    public Cars(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
