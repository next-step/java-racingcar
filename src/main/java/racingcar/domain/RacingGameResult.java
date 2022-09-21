package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private static final String MOVEMENT_MARK = "-";
    public static final String NEW_LINE = "\n";

    List<String> records = new ArrayList<>();

    public void record(Cars cars) {
        records.add(createStringRecord(cars));
    }

    private String createStringRecord(Cars cars) {
        StringBuilder record = new StringBuilder();

        cars.getCars()
            .stream()
            .map(this::createMovementMark)
            .forEach(record::append);

        return record.toString();
    }

    private String createMovementMark(Car car) {
        return MOVEMENT_MARK.repeat(car.position()) + NEW_LINE;
    }

    public List<String> records() {
        return Collections.unmodifiableList(records);
    }
}
