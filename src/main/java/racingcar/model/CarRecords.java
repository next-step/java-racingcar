package racingcar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarRecords implements Iterable<CarRecord> {
    private final List<CarRecord> carRecords;

    public CarRecords() {
        this.carRecords = new ArrayList<>();
    }

    public void add(CarRecord carRecord) {
        this.carRecords.add(carRecord);
    }

    @Override
    public Iterator<CarRecord> iterator() {
        return carRecords.iterator();
    }
}
