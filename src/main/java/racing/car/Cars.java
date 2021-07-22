package racing.car;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
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
