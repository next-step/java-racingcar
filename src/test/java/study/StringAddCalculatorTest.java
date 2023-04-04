package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static study.constant.StringCalcConstant.NEGATIVE_NUMBER_ERROR_MESSAGE;

class StringAddCalculatorTest {


    @Test
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, \"1,2\" => 3, \"1,2,3\" => 6, “1,2:3” => 6)")
    void test() {
        // Given
        final StringAddCalculator stringAddCalculator = new StringAddCalculator("1,2:3");

        // When
        final int add = stringAddCalculator.add();

        // Then
        assertThat(add).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "| 0",
            "1| 1",
            "1,2| 3",
            "1,2,3| 6",
            "1,2:3| 6"
    }, delimiterString = "|")
    @DisplayName("문자열 덧셈 '' => 0, \"1,2\" => 3, \"1,2,3\" => 6, “1,2:3” => 6 을 반환 하여야 한다")
    void test2(String numbers, int expected) {
        // Given
        final StringAddCalculator stringAddCalculator = new StringAddCalculator(numbers);

        // When
        final int add = stringAddCalculator.add();

        // Then
        assertThat(add).isEqualTo(expected);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\\n1;2;3” => 6)")
    void test3() {
        // Given
        final StringAddCalculator stringAddCalculator = new StringAddCalculator("//;\n1;2;3");

        // When
        final int add = stringAddCalculator.add();

        // Then
        assertThat(add).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)")
    void test4() {
        // Given
        final StringAddCalculator stringAddCalculator = new StringAddCalculator("-1,2,3");

        // When & Then
        assertThatThrownBy(stringAddCalculator::add)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_ERROR_MESSAGE, -1);
    }

}