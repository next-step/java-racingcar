package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsRecord {
    private final List<CarRecord> values;

    public CarsRecord() {
        this(new ArrayList<>());
    }

    public CarsRecord(List<CarRecord> values) {
        this.values = values;
    }

    public void add(final Car car) {
        values.add(car.generateRecord());
    }

    public List<CarRecord> getValues() {
        return values;
    }
}
