package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRoundRecord {

    private final List<CarDto> racingRecord;

    public RacingRoundRecord(List<CarDto> racingRecord) {
        this.racingRecord = racingRecord;
    }

    public static RacingRoundRecord from(List<Car> cars) {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(CarDto.from(car));
        }

        return new RacingRoundRecord(result);
    }

    public List<CarDto> getRacingRecord() {
        return racingRecord;
    }
}
