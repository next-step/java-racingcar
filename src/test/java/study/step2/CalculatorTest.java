package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step2.Calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @DisplayName("calculate 메소드 테스트 : +")
    @ParameterizedTest
    @CsvSource({
            "1 + 2, 3",
            "3 + 4 + 5, 12",
            "12 + 10 + 1200 + 500, 1722"
    })
    void addTest(String formula, int result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @DisplayName("calculate 메소드 테스트 : -")
    @ParameterizedTest
    @CsvSource({
            "1 - 2, -1",
            "100 - 4 - 6, 90",
            "500 - 100 - 100 - 100, 200"
    })
    void minusTest(String formula, int result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @DisplayName("calculate 메소드 테스트 : *")
    @ParameterizedTest
    @CsvSource({
            "1 * 2, 2",
            "-2 * 100 * 200, -40000",
            "1 * 100 * 0 * 700, 0"
    })
    void multiplyTest(String formula, int result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @DisplayName("calculate 메소드 테스트 : /")
    @ParameterizedTest
    @CsvSource({
            "400 / 2, 200",
            "300 / 3 / 3, 33",
            "500 / 100 / 5 / 100, 0"
    })
    void divideTest(String formula, int result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @DisplayName("calculate 메소드 테스트 : 랜덤")
    @ParameterizedTest
    @CsvSource({
            "2 + 3 * 4 / 2, 10",
            "3 * 9 + 100 / 5 - 10, 15",
            "5 - 20 / 3 + 120 * 10, 1150"
    })
    void calculateTest(String formula, int result) {
        assertEquals(result, calculator.calculate(formula));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("input check 테스트")
    void inputCheckTest(String formula) {
        assertThatThrownBy(() -> calculator.calculate(formula))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("input 값이 없습니다.");
    }


    @Test
    @DisplayName("operator check 테스트")
    void operatorCheckTest() {
        assertThatThrownBy(() -> calculator.calculate("1 x 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 연산자가 아닙니다.");
    }

}
