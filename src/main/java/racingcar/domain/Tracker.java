package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Tracker {

    private final List<Record> records = new ArrayList<>();

    public void saveRecords(Cars cars) {
        if (cars.isEmpty()) {
            throw new IllegalStateException("자동차는 한 대 이상이어야 기록됩니다.");
        }

        cars.saveRecords(records);
    }

    public List<Record> findAllRecords() {
        return records;
    }
}
