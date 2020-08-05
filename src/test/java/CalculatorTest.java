import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("Test Set For Calculation class - " +
        "Four operations and Null, Blank Exception")
class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void splitString() {
        String[] value = "1 + 2".split(" ");
        assertThat(value).contains("+");
    }

    /* 기본 연산에 대한 Test는 OperationTest로 분리 */
    @ParameterizedTest
    @NullSource
    void usingCheckNullAndBlankMethod(String input) {
        assertThat(calc.isNullOrBlank(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 - 2"})
    @DisplayName("Several Calculation with Only one Method used")
    void MultiOperationCalculationWithOneMethod(String input) {
        assertThat(calc.calculateWithFullString(input)).isEqualTo(2);
    }

    //조금 복잡한 경우?
    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 - 23 / 4 * 4"})
    @DisplayName("Several Calculation with Only one Method used_Complex")
    void MultiOperationCalculationWithOneMethod2(String input) {
        assertThat(calc.calculateWithFullString(input)).isEqualTo(-20);
    }


    // NULL, Empty value에 대해서 Exception 발생여부 체크
    // Calculator의 Exception Test
    @ParameterizedTest
    @NullAndEmptySource
    void NullAndEmptyStringInputValueExceptionTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculateWithFullString(input));
    }

    //Exception Check
    // 입력 단계에서 Exception 테스트 체크
    @ParameterizedTest
    @NullSource
    void NullStringInputValueExceptionTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculateWithFullString(input));
    }

    //Exception Check
    //EmptySource 사용
    //
    @ParameterizedTest
    @EmptySource
    void SpaceStringInputValueExceptionTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculateWithFullString(input));
    }
}
