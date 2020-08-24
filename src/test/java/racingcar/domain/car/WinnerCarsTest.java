package racingcar.domain.car;

import org.junit.jupiter.api.Test;
import racingcar.domain.Position;
import static racingcar.domain.car.WinnerCars.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCarsTest {

    @Test
    void winnersNamesTest() {
        List<Car> carList = new ArrayList<>();
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(4));
        Car honux = new Car ("honux", new Position(4));
        carList.add(pobi);
        carList.add(crong);
        carList.add(honux);
        assertThat(getWinnersNames(carList)).isEqualTo("crong, honux");
    }
}
