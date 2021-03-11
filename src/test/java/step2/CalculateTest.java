package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateTest {

    private Calculate calculate;

    @BeforeEach
    void setUp() {
        calculate = new Calculate();
    }

    @Test
    @DisplayName("성공하는 연산식의 테스트 코드")
    void successOperation() {
        String[] formula = {"2", "*", "3"};
        assertEquals(6, calculate.calculateFormula(formula));
    }


    @Test
    @DisplayName("숫자 또는 연산자가 아닐 경우에 예외가 발생하는 테스트 코드")
    void notOperationIsThrowException() {
        String[] formula = {"2", "(", "3"};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.isCheckOperation(formula);
                });
    }

    @ParameterizedTest()
    @ValueSource(strings = {"", " "})
    @DisplayName("공백문자 또는 빈 문자열이라면 예외가 발생하는 테스트 코드")
    void emptyOrNullInputIsThrowException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Validator.isEmptyOrIsBlankOrIsNull(input);
                });
    }
}

