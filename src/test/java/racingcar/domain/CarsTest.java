package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("우승 자동차를 찾아낸다. 우승 자동차는 'pobi', 'honux' 이다.")
    void findWinners_thenContainWinners() {
        Car pobi = new Car("pobi", 5);
        Car crong = new Car("crong", 4);
        Car honux = new Car("honux", 5);
        List<Car> carValues = Arrays.asList(pobi, crong, honux);
        Cars winners = new Cars(carValues);

        assertThat(winners.findWinners()).containsExactly(pobi, honux);
    }
}
