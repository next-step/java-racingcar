package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 우승자가 포함되어 있는지 확인한다.")
    void carsTest_getWinnerNames() {
        List<CarName> carNames = List.of(new CarName("pobi"), new CarName("honux"));
        Cars cars = new Cars(carNames);

        String[] winners = cars.getWinnerNames().toArray(new String[0]);
        assertThat(carNames.stream().map(CarName::getValue).toArray()).contains(winners);
    }
}
