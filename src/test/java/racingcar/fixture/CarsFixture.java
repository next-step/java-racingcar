package racingcar.fixture;

import java.util.List;
import racingcar.domain.Cars;

public class CarsFixture {

    public final static List<String> CAR_NAMES = List.of("car1", "car2", "car3");

    public static Cars cars() {
        return Cars.from(CAR_NAMES);
    }
}
