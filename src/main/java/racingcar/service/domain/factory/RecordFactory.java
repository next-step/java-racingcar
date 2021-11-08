package racingcar.service.domain.factory;

import racingcar.service.domain.Car;
import racingcar.service.domain.Record;
import racingcar.service.model.Cars;
import racingcar.service.value.Round;

import java.util.List;

public final class RecordFactory {
    private RecordFactory() {
    }

    public static Record create(Integer round, List<Car> cars) {
        return new Record(Round.from(round), Cars.from(cars));
    }
}
