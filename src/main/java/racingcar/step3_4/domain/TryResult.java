package racingcar.step3_4.domain;

import java.util.List;
import java.util.stream.Collectors;

public class TryResult {

    private final List<TryRecord> tryRecords;

    private TryResult(List<TryRecord> tryRecords) {
        this.tryRecords = tryRecords;
    }

    public static TryResult of(List<Car> cars) {
        List<TryRecord> records = cars.stream()
            .map(car -> new TryRecord(car.getName(), car.getPosition()))
            .collect(Collectors.toList());

        return new TryResult(records);
    }

    public List<TryRecord> getRecords() {
        return List.copyOf(tryRecords);
    }
}
