package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private static final String NEW_LINE = "\n";

    List<String> records = new ArrayList<>();

    public void record(Cars cars) {
        records.add(createStringRecord(cars));
    }

    private String createStringRecord(Cars cars) {
        StringBuilder record = new StringBuilder();

        for (Car car : cars.getCars()) {
            String distance = "-".repeat(car.position());
            record.append(distance)
                    .append(NEW_LINE);
        }

        return record.toString();
    }

    public String getReport() {
        return String.join(NEW_LINE, records);
    }
}
