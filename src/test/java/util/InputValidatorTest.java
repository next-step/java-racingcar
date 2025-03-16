package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("자동차 수가 0 이하면 예외가 발생한다.")
    public void checkValidCarCount(int carCount) {
        assertThatThrownBy(() -> InputValidator.checkValidCarCount(carCount))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("시도할 수가 0 이하면 예외가 발생한다.")
    public void checkValidTryCount(int tryCount) {
        assertThatThrownBy(() -> InputValidator.checkValidTryCount(tryCount))
                .isInstanceOf(RuntimeException.class);
    }
}