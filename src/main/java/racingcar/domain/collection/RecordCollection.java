package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Record;

import java.util.List;

public class RecordCollection {

    private RecordCollection() {

    }

    public static Record create(int tryCount, List<RacingCar> cars) {
        return new Record(tryCount, RacingCars.create(cars));
    }
}
