package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    void checkBlankTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.checkBlank(input));
    }

    @Test
    @DisplayName("더하기 테스트")
    void sumTest() {
        int actual = calculator.calculate("1 + 2");
        System.out.println(actual);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("마이너스 테스트")
    void minusTest() {
        int actual = calculator.calculate("1 - 2");
        System.out.println(actual);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void mutiplyTest() {
        int actual = calculator.calculate("2 * 3");
        System.out.println(actual);
        assertThat(actual).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest() {
        int actual = calculator.calculate("4 / 3");
        System.out.println(actual);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("통합 테스트")
    void calculateTest() {
        int actual = calculator.calculate("1 + 2 * 3 - 4 / 5");

        System.out.println(actual);
        assertThat(actual).isEqualTo(1);
    }
}
