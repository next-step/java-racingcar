package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RunCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"1 - 1 , 0", "10 - 5 - 2 , 3"}, delimiter = ',')
    @DisplayName("뺄셈 전체 테스트")
    void totalSubTest(String paramText, Integer result) {
        assertEquals(RunCalculator.runCalculator(paramText), result);
    }


    @ParameterizedTest
    @CsvSource(value = {"2 * 2 , 4", "6 * 2 * 2 , 24"}, delimiter = ',')
    @DisplayName("곱셈 전체 테스트")
    void totalMulTest(String paramText, Integer result) {
        assertEquals(RunCalculator.runCalculator(paramText), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 / 2 , 1", "6 / 2 / 3 , 1"}, delimiter = ',')
    @DisplayName("나눗셈 전체 테스트")
    void totalDivTest(String paramText, Integer result) {
        assertEquals(RunCalculator.runCalculator(paramText), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3,5", "1 + 1 + 3, 5"}, delimiter = ',')
    @DisplayName("덧셈 전체 테스트")
    void totalAddTest(String paramText, Integer result) {
        assertEquals(RunCalculator.runCalculator(paramText), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 5 / 5 - 5 ,0"}, delimiter = ',')
    @DisplayName("사칙연산 전체 테스트")
    void totalTest(String paramText, Integer result) {
        assertEquals(RunCalculator.runCalculator(paramText), result);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("Null 체크 테스트")
    void emptyTest(String paramText) {
        assertThrows(IllegalArgumentException.class, () -> {
            RunCalculator.runCalculator(paramText);
        });
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Empty 체크 테스트")
    void emptyOrNullTest(String paramText) {
        assertThrows(IllegalArgumentException.class, () -> {
            RunCalculator.runCalculator(paramText);
        });
    }

}
