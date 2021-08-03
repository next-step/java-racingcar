package racingcar.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Records implements Iterable<Record> {
    private final List<Record> records = new ArrayList<>();

    public Records(Cars cars) {
        for (Car car : cars) {
            records.add(new Record(car.getName(), car.getDistance()));
        }
    }

    @Override
    public Iterator<Record> iterator() {
        return records.iterator();
    }
}
