package racingcar_step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @Test
    @DisplayName("Test1 Input String is Null")
    void inputNullTest() {
        String input = null;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test2 Input String is Empty String")
    void inputEmptyTest() {
        String input = "  ";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test3 Plus")
    void plusTest() {
        String input = "2 + 5 + 10";
        Calculator calculator = new Calculator(input);
        assertThat(17).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test4 Minus")
    void  minusTest() {
        String input = "20 - 1 - 3";
        Calculator calculator = new Calculator(input);
        assertThat(16).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test5 Multiplication")
    void multiplicationTest() {
        String input = "2 * 3 * 4";
        Calculator calculator = new Calculator(input);
        assertThat(24).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test6 Division")
    void divisionTest() {
        String input = "100 / 2";
        Calculator calculator = new Calculator(input);
        assertThat(50).isEqualTo(calculator.getResult());
    }

    @Test
    @DisplayName("Test7 Division Zero")
    void divisionZeroTest() {
        String input = "100 / 0";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test8 Disabled character")
    void inputDisabledCharacterTest() {
        String input = "2 / 4 $ 3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }

    @Test
    @DisplayName("Test9 Consecutive Disabled character")
    void intputConsecutiveDisabledCharacterTest() {
        String input = "2 / ! $ 3";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(input);
        });
    }
}
