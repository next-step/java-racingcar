package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 식별자(CarIndex) 테스트")
public class CarIndexTest {

    @DisplayName("자동차 식별자는 자동차(Car)를 식별하는 하나의 숫자를 의미한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    void create(int value) {
        // when
        CarIndex carIndex = CarIndex.valueOf(value);

        // when / then
        assertThat(carIndex).isNotNull();
    }
}
