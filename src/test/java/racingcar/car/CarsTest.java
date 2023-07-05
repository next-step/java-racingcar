package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CarsTest {

    @Test
    void carsTest_getWinnerNames() {
        List<String> carNames = List.of("pobi", "honux");
        Cars cars = new Cars(carNames.stream().map(CarName::new).collect(Collectors.toList()));

        String[] winners = cars.getWinnerNames().toArray(new String[0]);
        Assertions.assertThat(carNames).contains(winners);
    }
}
