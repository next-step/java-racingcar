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
    @ValueSource(strings = {"pobi,crong,honux", "a,b,c,d,e"})
    @DisplayName("입력한 자동차 이름을 ','로 구분하고, 구분한 개수만큼 자동차를 생성한다.")
    void carsCreateTest_thenIsEqualTo(String carNames) {
        Cars cars = new Cars(carNames);
        List<Car> values = cars.getValues();

        assertThat(cars).isEqualTo(new Cars(values));
    }
}
