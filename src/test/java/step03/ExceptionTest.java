package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import exception.NotPositiveIntegerException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ExceptionTest {

    @DisplayName("입력값이 양의 정수가 아닐 때 예외를 일으킴")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -13})
    public void 양의정수가_아닐때_예외_테스트(int input) {
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> {
                   Validator.validatePositiveNumber(input);
                });
    }
}
