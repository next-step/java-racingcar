package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux"})
    @DisplayName("입력한 자동차 이름을 ','로 구분하고, 구분한 개수만큼 cars의 사이즈가 같다.")
    void carsCreateTest_thenIsEqualTo(String carNames) {
        Cars cars = new Cars(carNames);

        assertThat(cars).isEqualTo(new Cars(carNames));
    }

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
