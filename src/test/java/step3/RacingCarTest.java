package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("random 값이 4이상인경우 전진합니다")
    void advance_test(int randomValue) {
        Car car = new Car("-");
        assertThat(car.getAdvancedOrDefaultLocation(randomValue).toString()).isEqualTo("--");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("random 값이 4미만인경우 전진하지않습니다")
    void not_advance_test(int randomValue) {
        Car car = new Car("-");
        assertThat(car.getAdvancedOrDefaultLocation(randomValue).toString()).isEqualTo("-");
    }
}
