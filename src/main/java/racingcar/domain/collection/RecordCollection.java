package racingcar.domain.collection;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.Record;
import racingcar.service.util.Validation;

import java.util.List;

public class RecordCollection {

    private RecordCollection() {

    }

    public static Record create(int tryCount, List<RacingCar> cars) {

        Validation.nullValueCheck(cars);
        Validation.numberCheck(Integer.toString(tryCount));

        return new Record(tryCount, RacingCars.create(cars));
    }
}
