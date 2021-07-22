package racing.car;

import util.RandomUtils;
import util.StringUtils;

import java.util.*;
import java.util.function.Consumer;

public class Cars implements Iterable<Car> {
    private final List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    public void broadCast(Consumer<Car> callback) {
        for (Car iCar : values) {
            callback.accept(iCar);
        }
    }

    public void add(Car car) {
        values.add(car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
