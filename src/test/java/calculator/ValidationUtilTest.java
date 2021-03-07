package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ValidationUtilTest {


    @DisplayName("입력 값의 크기가 값이 3보다 작거나 값과 전체 Size가 짝수일 때 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 *"})
    void validateInputSize(String input) {
        //GIVE

        //WHEN
        String[] inputArray = input.split(" ");
        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ValidationUtil.validateInput(inputArray));
    }

    @DisplayName("연산자 값이 사칙연산이 아닐떄 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1 ! 3"})
    void validateInputOperator(String input) {
        //GIVE

        //WHEN
        String[] inputArray = input.split(" ");
        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ValidationUtil.validateInput(inputArray));
    }

    @DisplayName("입력 값이 Null일때  NullPointerException 발생")
    @Test
    void validateInputNull() {
        //GIVE
        String input = "";
        //WHEN
        String[] inputArray = input.split(" ");
        //THEN
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ValidationUtil.validateInput(inputArray));
    }
}
