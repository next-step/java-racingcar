package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void findWinnersTest() {
        List<Car> carList = new ArrayList<>();
        Car pobi = new Car("pobi", new Position(3));
        Car crong = new Car("crong", new Position(4));
        Car honux = new Car ("honux", new Position(4));
        carList.add(pobi);
        carList.add(crong);
        carList.add(honux);

        assertThat(carList).hasSize(3);
        assertThat(Cars.findWinners(carList)).hasSize(2);
        assertThat(Cars.findWinners(carList)).containsExactly(crong, honux);
    }
}
