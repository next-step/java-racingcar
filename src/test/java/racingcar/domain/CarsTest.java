package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = {" ,ab ", "abcde, 123456", "boradol, boradol2, boradol3"})
    @DisplayName("자동차 이름을 입력하고 입력이 불가한 것은 Exception 발생한다. - 1) 공백 제외, 2) 5자초과 x")
    void test(String input) {
        assertThatThrownBy(() -> new Cars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 100})
    @DisplayName("입력한 차 대수만큼의 차들이 이동한다.")
    void movingCarsTest_thenIsEqualTo(int carCount) {
        Cars cars = new Cars(carCount);
        cars.move(new RandomValueMovingStrategy());
        List<Car> values = cars.getValues();

        assertThat(cars).isEqualTo(new Cars(values));
    }
}
