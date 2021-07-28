package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Distances implements Iterable<Distance> {
    private List<Distance> distances = new ArrayList<>();

    public Distances(Cars cars) {
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
    }

    @Override
    public Iterator<Distance> iterator() {
        return distances.iterator();
    }
}
