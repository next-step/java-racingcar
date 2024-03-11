package racingcar.fake;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class FakeCars extends Cars {

    public static final List<Car> FAKE_CAR_LIST = List.of(new Car("a"), new Car("b"));

    @SuppressWarnings("all")
    public FakeCars() {
        super(FAKE_CAR_LIST);
    }

    @Override
    public Winners winners() {
        return new Winners(FAKE_CAR_LIST);
    }
}
