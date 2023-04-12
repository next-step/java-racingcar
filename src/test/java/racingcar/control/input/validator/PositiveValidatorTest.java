package racingcar.control.input.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveValidatorTest {

    private final PositiveValidator validator = new PositiveValidator();

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("양의 정수가 아니면 에러가 나야한다")
    public void verify(int input) {
        Assertions.assertThatThrownBy(() -> validator.verify(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("input must be positive");
    }
}