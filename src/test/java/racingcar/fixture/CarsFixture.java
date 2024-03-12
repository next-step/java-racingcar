package racingcar.fixture;

import java.util.List;
import racingcar.domain.Cars;

public class CarsFixture {

    public static final List<String> CAR_NAMES = List.of(
        CarNameFixture.K3,
        CarNameFixture.K5,
        CarNameFixture.K7
    );

    public static Cars cars() {
        return Cars.from(CAR_NAMES);
    }
}
