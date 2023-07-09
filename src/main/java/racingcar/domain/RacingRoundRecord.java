package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingRoundRecord {

    private final List<CarRecord> racingRecord;

    public RacingRoundRecord(List<CarRecord> racingRecord) {
        this.racingRecord = racingRecord;
    }

    public static RacingRoundRecord from(List<Car> cars) {
        List<CarRecord> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(CarRecord.from(car));
        }

        return new RacingRoundRecord(result);
    }

    public List<CarRecord> getRacingRecord() {
        return racingRecord;
    }
}
