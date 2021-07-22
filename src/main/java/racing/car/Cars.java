package racing.car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private List<Car> values;

    public Cars() {
        this.values = new ArrayList<>();
    }

    public void moveAll() {
        for(Car iCar : values)
            iCar.move();
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
