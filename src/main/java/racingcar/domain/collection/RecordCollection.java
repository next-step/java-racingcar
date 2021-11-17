package racingcar.domain.collection;

import racingcar.domain.RacingCars;
import racingcar.domain.Record;
import racingcar.domain.Records;
import racingcar.service.util.Validation;

import java.util.List;

public class RecordCollection {

    private RecordCollection() {

    }

    public static Record create(int tryCount, RacingCars cars) {

        return new Record(tryCount, cars);
    }

    public static Records create(List<Record> records) {

        return new Records(records);
    }
}
