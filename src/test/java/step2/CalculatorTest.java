package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private Calculator calculator;
    private InputCheck inputCheck;

    @BeforeEach
    void newObject() {
        inputCheck = new InputCheck();
        calculator = new Calculator();
    }

    @DisplayName("덧셈을 연산한다.")
    @Test
    void addittion() {
        double addittion = calculator.addittion(1, 3);
        assertThat(addittion).isEqualTo(4);
    }

    @DisplayName("뺄셈을 연산한다.")
    @Test
    void subtraction() {
        double subtraction = calculator.subtraction(9, 3);
        assertThat(subtraction).isEqualTo(6);
    }

    @DisplayName("곱셈을 연산한다.")
    @Test
    void multiplication() {
        double multiplication = calculator.multiplication(2, 5);
        assertThat(multiplication).isEqualTo(10);
    }

    @DisplayName("나눗셈을 연산한다.")
    @Test
    void division() {
        double division = calculator.division(10, 2);
        assertThat(division).isEqualTo(5);
    }

    static Stream<String> blankStrings() {
        return Stream.of("", "   ", null);
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우를 확인한다.")
    @ParameterizedTest
    @MethodSource("blankStrings")
    void checkInputArgumentException(final String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputCheck.checkEmptyInput(input);
        });
    }

    @DisplayName("사칙연산 기호가 아닌 경우를 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = { ".", "^", ">", "~" })
    void checkArithmeticSymbolException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            inputCheck.checkOperation(input);
        });
    }

    @DisplayName("사칙 연산을 모두 포함한다.")
    @ParameterizedTest
    @CsvSource(value = { "6 + 3 * 4 / 2 : 18", "2 + 3 * 4 / 2 : 10" }, delimiter = ':')
    void calculation(String input, double expected) {
        inputCheck.checkAndClassify(input);
        calculator = new Calculator(inputCheck.getNumList(), inputCheck.operationList);
        double result = calculator.resultCalc();
        assertThat(result).isEqualTo(expected);

    }
}