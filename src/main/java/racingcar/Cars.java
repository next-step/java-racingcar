package racingcar;

import java.util.*;
import java.util.stream.Stream;

public class Cars {
    private final Set<Car> carSet;

    public Cars() {
        carSet = new HashSet<>();
    }

    public void add(Car car) {
        carSet.add(car);
    }

    public boolean contains(Car car) {
        return carSet.contains(car);
    }

    public Stream<Car> stream() {
        return carSet.stream();
    }

    public int size() {
        return carSet.size();
    }

    public void clear() {
        carSet.clear();
    }
}
