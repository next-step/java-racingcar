package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CarsTest {

    @Test
    void carsTest_getWinnerNames() {
        List<String> carNames = List.of("pobi", "honux");
        Cars cars = new Cars(carNames);

        String[] winners = cars.getWinnerNames().toArray(new String[0]);
        Assertions.assertThat(carNames).contains(winners);
    }
}
