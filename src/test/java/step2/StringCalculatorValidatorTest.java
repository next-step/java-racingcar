package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorValidatorTest {

    private StringCalculatorValidator stringCalculatorValidator;

    @BeforeEach
    void setUp() {
        this.stringCalculatorValidator = new StringCalculatorValidator();
    }

    @DisplayName("문자열이 비어있으면 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings={""," ","   "})
    void assertIsNotNullOrEmpty(String string) {
        assertThrows(IllegalArgumentException.class,()->stringCalculatorValidator.validateIsNotNullOrEmpty(string));
    }

    @DisplayName("String 배열이 숫자가 아닌 값으로 시작하거나 끝나면 IllegalArgumentException 발생")
    @Test
    void assertExpressionStartOrEndNumber() {
        String[] given = new String[]{"-","1","+","2"};
        assertThrows(IllegalArgumentException.class,()->stringCalculatorValidator.validateExpressionStartOrEndNumber(given));
    }

    @DisplayName("연산자의 수가 연산할 숫자의 수보다 1개 적지 않으면 IllegalArgumentException 발생")
    @Test
    void validateOperatorCount() {
        int givenCountOfOperators = 3;
        int givenCountOfNumbers = 3;
        assertThrows(IllegalArgumentException.class,()->stringCalculatorValidator.validateOperatorCount(givenCountOfOperators,givenCountOfNumbers));
    }

}