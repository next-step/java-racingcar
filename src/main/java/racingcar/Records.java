package racingcar;

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

    public Records() {}

    @Override
    public Iterator<Record> iterator() {
        return records.iterator();
    }

    public void recordBest(Record record) {
        if (records.isEmpty()) {
            records.add(record);
            return;
        }
        if (records.get(0).getDistance() < record.getDistance()) {
            records.clear();
            records.add(record);
            return;
        }
        if (records.get(0).getDistance() == record.getDistance()) {
            records.add(record);
        }
    }
}
