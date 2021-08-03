package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String ...names) {
        for(String name : names) {
            cars.add(new Car(name));
        }
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
