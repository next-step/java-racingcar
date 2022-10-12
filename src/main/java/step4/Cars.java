package step4;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars winners() {
        Map<Integer, List<Car>> result = this.cars.stream().collect(Collectors.groupingBy(Car::location));
        Integer winnerKey = Collections.max(result.keySet());
        return new Cars(result.get(winnerKey));

    }

    @Override
    public Iterator<Car> iterator() {
        return this.cars.iterator();
    }
}
