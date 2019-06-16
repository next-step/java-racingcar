package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("정상 예시 테스트")
    @CsvSource( value = {
            "2 + 3 * 4 / 2, 10",
            "4 + 2 / 2 * 5, 15",
            "1 + 1, 2",
            "3 * 4, 12",
            "10 - 4 / 3 * 2, 4",
            "10 * 100, 1000",
            "25 * 2, 50",
            "15 / 3 + 5 * 2, 20"
    })
    public void correctCalculation(String input, int expected) {
        stringCalculator.setFormula(input);
        assertThat(stringCalculator.getTotal()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("잘못된 계산식 테스트")
    @ValueSource( strings = {
            "2 + 3 * 4  2 / 2",
            "25 *  + 2",
            "15 / 3 + 5  6 * 2"
    })
    public void errorCalculationTest(String input) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.setFormula(input);
            stringCalculator.getTotal();
        });
    }

    @Test
    @DisplayName("Null 입력시 예외처리")
    public void nullExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.setFormula(null);
        });
    }

    @Test
    @DisplayName("빈 문자열 입력시 예외처리")
    public void emptyStringExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.setFormula("");
        });
    }

    @Test
    @DisplayName("특수문자 입력시 예외처리")
    public void specialCharacterExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringCalculator.setFormula("10 $ 2 % 3");
        });
    }
}
