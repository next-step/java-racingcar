package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import exception.NotPositiveIntegerException;
import validator.NumberValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ExceptionTest {

    @DisplayName("입력값이 양의 정수가 아닐 때 예외를 일으킴")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, -13})
    public void Given_NoAPositiveInteger_Then_ThrowException(int input) {
        assertThatExceptionOfType(NotPositiveIntegerException.class)
                .isThrownBy(() -> {
                   NumberValidator.validatePositiveInteger(input);
                });
    }
}
