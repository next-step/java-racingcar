package carracing.domain.record;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundRecord {
    private final List<CarRecord> carRecords = new ArrayList<>();

    private RoundRecord(List<CarRecord> cars) {
        this.carRecords.addAll(cars);
    }

    public static RoundRecord from(List<CarRecord> cars) {
        return new RoundRecord(cars);
    }

    public List<CarRecord> getCarRecords() {
        return carRecords.stream()
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getLeadingCarNames() {
        return carRecords.stream()
                .filter(carRecord -> carRecord.isPositionEqualTo(calculateMaxPosition()))
                .map(CarRecord::getName)
                .collect(Collectors.toUnmodifiableList());
    }

    private int calculateMaxPosition() {
        return carRecords.stream()
                .mapToInt(CarRecord::getPosition)
                .max()
                .orElse(0);
    }

}
