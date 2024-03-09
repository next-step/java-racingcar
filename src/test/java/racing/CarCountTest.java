package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.CarCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarCountTest {
    @Test
    void 자동차대수_입력() {
        CarCount carCount = new CarCount("3");
        assertThat(carCount.getNumberOfRacingCar()).isEqualTo(3);
    }

    @DisplayName("숫자가 아닌 값, 0 이하의 숫자, 공백, Null 값 입력했을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"A", "0", "-3", "", " "})
    @NullSource
    void 적절하지_않은_자동차대수_입력(String input) {
        assertThatThrownBy(() -> new CarCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
