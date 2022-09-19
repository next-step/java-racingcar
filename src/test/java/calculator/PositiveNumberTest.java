package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositiveNumberTest {

    @DisplayName("0 이상 값으로 생성 시 정상 작동")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void constructor(int input) {
        assertDoesNotThrow(() -> new PositiveNumber(input));
    }

    @DisplayName("음수로 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void constructor_exception(int input) {
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(RuntimeException.class);
    }
}
