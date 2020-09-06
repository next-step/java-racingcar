package racingcar.domain.record;
import racingcar.domain.car.Cars;

import java.util.Map;
import java.util.Objects;

public class RacingRecord {

    private final Map<String, Integer> racingRecord;

    public RacingRecord(Map<String, Integer> racingRecord) {
        this.racingRecord = racingRecord;
    }

    public Map<String, Integer> getRacingRecord() {
        return racingRecord;
    }

    public static RacingRecord makeRacingRecordOf(Cars cars) {
        return new RacingRecord(cars.toRacingRecord());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingRecord that = (RacingRecord) o;
        return Objects.equals(racingRecord, that.racingRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingRecord);
    }
}
