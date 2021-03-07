package study.step2;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void init(){
        calculatorService = new CalculatorService();
    }

    @Test
    @DisplayName("입력 Null 테스트")
    void inputNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.Calculate(null));
    }

    @ParameterizedTest(name = "입력 빈값 테스트")
    @ValueSource(strings = {"", "  "})
    void inputEmpty(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.Calculate(input));
    }

    @Test
    @DisplayName("입력 연산기호 유효성 테스트")
    void validOperator() {
        String str = "2 ^ 3 + 2";
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.Calculate(str));
    }

    @Test
    @DisplayName("입력 숫자 유효성 테스트")
    void validNumber() {
        String str = "1 + 3 * a";
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.Calculate(str));
    }

    @ParameterizedTest(name = "Calculate 테스트")
    @CsvSource(value = {"2 + 3 * 4 / 2 : 10", "2 * 3 / 2 - 5 : -2", "4 + 1 - 2 * -4 / 5 : -2"}, delimiter = ':')
    void calculalate(String input, int expected){
        assertThat(calculatorService.Calculate(input)).isEqualTo(expected);
    }
}
