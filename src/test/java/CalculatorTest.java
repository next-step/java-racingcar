import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("입출력 검증")
    void process() {

        assertThat(calculator.process("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(calculator.process("2 + 3 * 4")).isEqualTo(20);
        assertThat(calculator.process("2 + 3")).isEqualTo(5);
        assertThat(calculator.process("2 + 3 * 4 / 2 + 5 * 9 - 8 + 2")).isEqualTo(129);

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.process("2")).withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.process("2 + 3 * 4 /")).withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.process("      ")).withMessage("입력값이 유효하지 않습니다.");
    }

    @Test
    @DisplayName("입력값이 null 또는 공백으로만 이루어진 String 이라면 IllegalArgumentException 발생한다.")
    void validateInput() {

        List<String> invalidInputs = Arrays.asList(null, "", " ", "    ");

        invalidInputs.forEach(invalidInput ->
                                      assertThatIllegalArgumentException()
                                              .isThrownBy(() -> calculator.validateInput(invalidInput))
                                              .withMessage("입력값이 유효하지 않습니다."));

    }

    @Test
    @DisplayName("토큰화할때 공백은 제외한다.")
    void tokenizeInput() {

        assertThat(calculator.tokenize("2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
        assertThat(calculator.tokenize("2 +      3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
        assertThat(calculator.tokenize("     2 + 3 * 4 / 2")).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("토큰의 개수는 3개 이상이고 홀수여야하며, 연산기호는 (+, -, *, /)만 허용된다.")
    void validateToken() {

        assertThatCode(() -> calculator.validateToken(Arrays.asList("2", "+", "3", "*", "4", "/", "2"))).doesNotThrowAnyException();
        assertThatCode(() -> calculator.validateToken(Arrays.asList("2", "+", "3"))).doesNotThrowAnyException();
        assertThatCode(() -> calculator.validateToken(Arrays.asList("3", "*", "4"))).doesNotThrowAnyException();
        assertThatCode(() -> calculator.validateToken(Arrays.asList("4", "/", "2"))).doesNotThrowAnyException();

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4", "/", "2", "+")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4", "/")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4")))
                .withMessage("연산자의 개수가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Collections.emptyList()))
                .withMessage("연산자의 개수가 유효하지 않습니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4", ",", "3")))
                .withMessage("연산기호가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4", "3", "3")))
                .withMessage("연산기호가 유효하지 않습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.validateToken(Arrays.asList("4", "%", "3")))
                .withMessage("연산기호가 유효하지 않습니다.");
    }

    @Test
    void calculate() {

        List<String> tokens1 = Arrays.asList("2", "+", "3", "*", "4", "/", "2");
        assertThat(calculator.calculate(tokens1)).isEqualTo(10);

        List<String> tokens2 = Arrays.asList("6", "-", "3");
        assertThat(calculator.calculate(tokens2)).isEqualTo(3);

        List<String> tokens3 = Arrays.asList("3", "*", "4");
        assertThat(calculator.calculate(tokens3)).isEqualTo(12);

        List<String> tokens4 = Arrays.asList("4", "/", "2");
        assertThat(calculator.calculate(tokens4)).isEqualTo(2);

        List<String> tokens5 = Arrays.asList("4", "/", "0");
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> calculator.calculate(tokens5));
    }
}
