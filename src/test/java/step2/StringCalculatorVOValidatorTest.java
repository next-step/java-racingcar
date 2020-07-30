package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorVOValidatorTest {

    private final StringCalculatorVOValidator stringCalculatorVOValidator = new StringCalculatorVOValidator();

    @DisplayName("문자열이 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings={""," ","   "})
    void validateIsNotNullOrEmpty(String string) {
        assertThrows(IllegalArgumentException.class,()-> stringCalculatorVOValidator.validateIsNotNullOrEmpty(string));
    }

    @DisplayName("String 배열이 숫자가 아닌 값으로 시작하거나 끝나면 IllegalArgumentException 발생")
    @Test
    void validateExpressionStartOrEndNumber() {
        String[] given = new String[]{"-","1","+","2"};
        assertThrows(IllegalArgumentException.class,()-> stringCalculatorVOValidator.validateExpressionStartOrEndNumber(given));
    }

    @DisplayName("숫자 사이에 연산자가 있지 않으면 IllegalArgumentException 발생")
    @Test
    void validateOperatorPlacedBetweenNumbers() {
        String[] given = new String[]{"1","-","-","1"};
        assertThrows(IllegalArgumentException.class,()-> stringCalculatorVOValidator.validateOperatorPlacedBetweenNumbers(given));
    }

    @DisplayName("연산자의 수가 연산할 숫자의 수보다 1개 적지 않으면 IllegalArgumentException 발생")
    @Test
    void validateOperatorCount() {
        int givenCountOfOperators = 3;
        int givenCountOfNumbers = 3;
        assertThrows(IllegalArgumentException.class,()-> stringCalculatorVOValidator.validateOperatorCount(givenCountOfOperators,givenCountOfNumbers));
    }

}
