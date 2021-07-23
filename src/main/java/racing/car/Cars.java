package racing.car;

import java.util.*;

public class Cars implements Iterable<Car> {
    private final List<Car> values;

    public Cars(List<Car> values) {
        this.values = values;
    }

    public void moveAll(Fuel fuel) {
        for (Car iCar : values)
            iCar.move(fuel);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
