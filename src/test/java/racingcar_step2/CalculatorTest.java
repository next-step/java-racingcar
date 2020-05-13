package racingcar_step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("문자열 사칙 연산 계산기 테스트")
public class CalculatorTest {

    @Test
    @DisplayName("Test1 입력값이 NULL인 경우")
    void inputNullTest() {
        String input = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test2 입력값이 비어있는 경우")
    void inputEmptyTest() {
        String input = "  ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test3 더하기")
    void plusTest() {
        String input = "2 + 5 + 10";
        Calculator calculator = new Calculator(input);
        assertThat(17).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test4 빼기")
    void  minusTest() {
        String input = "20 - 1 - 3";
        Calculator calculator = new Calculator(input);
        assertThat(16).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test5 곱셈")
    void multiplicationTest() {
        String input = "2 * 3 * 4";
        Calculator calculator = new Calculator(input);
        assertThat(24).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test6 나눗셈")
    void divisionTest() {
        String input = "100 / 2";
        Calculator calculator = new Calculator(input);
        assertThat(50).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test7 0을 나눌때")
    void divisionZeroTest() {
        String input = "100 / 0";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test8 허용하지 않은 특수문자 사용")
    void inputDisabledCharacterTest() {
        String input = "2 / 4 $ 3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test9 연속해서 허용하지 않는 특수문자 사용")
    void intputConsecutiveDisabledCharacterTest() {
        String input = "2 / ! $ 3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }
}
