package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Record {
    private final List<String> record = new ArrayList<>();

    public Record(Cars cars) {
        for (Car car : cars.getCars()) {
            this.record.add(car.getLocationToExpression());
        }
    }

    public List<String> getRecord() {
        return this.record;
    }

}
