package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private static final String NEW_LINE = "\n";
    private static final String MOVEMENT_MARK = "-";

    List<String> records = new ArrayList<>();

    public void record(Cars cars) {
        records.add(createStringRecord(cars));
    }

    private String createStringRecord(Cars cars) {
        StringBuilder record = new StringBuilder();

        for (Car car : cars.getCars()) {
            String distance = MOVEMENT_MARK.repeat(car.position());
            record.append(distance)
                    .append(NEW_LINE);
        }

        return record.toString();
    }

    public String getReport() {
        return String.join(NEW_LINE, records);
    }
}
