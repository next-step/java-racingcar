package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.InvalidNumberFormatException;
import calculator.exception.NotPositiveNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumbersTest {

    @DisplayName("컬렉션의 숫자를 더할 수 있다.")
    @Test
    void sum() {
        String[] numbers = {"1", "2", "3"};
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        assertThat(positiveNumbers.sum()).isEqualTo(6);
    }

    @DisplayName("빈 리스트를 전달하면 덧셈 결과 0을 반환한다.")
    @Test
    void emptyListReturnZero() {
        PositiveNumbers positiveNumbers = new PositiveNumbers(new String[]{});
        assertThat(positiveNumbers.sum()).isZero();
    }

    @DisplayName("숫자 이외의 문자열을 전달하는 경우 InvalidNumberFormatException 예외를 반환한다.")
    @Test
    void notNumber() {
        String[] numbers = {"1", "ab", "2"};
        assertThatExceptionOfType(InvalidNumberFormatException.class)
            .isThrownBy(() -> new PositiveNumbers(numbers));
    }

    @DisplayName("음수 문자열을 전달하는 경우 NotPositiveNumberException 예외를 반환한다.")
    @Test
    void negativeNumber() {
        String[] numbers = {"1", "-3", "2"};
        assertThatExceptionOfType(NotPositiveNumberException.class)
            .isThrownBy(() -> new PositiveNumbers(numbers));
    }
}
