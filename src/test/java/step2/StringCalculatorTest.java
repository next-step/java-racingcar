package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 + 1 - 10 * 5 / 2:-10"}, delimiter = ':')
    @DisplayName("문자열 계산기 테스트")
    void stringCalculatorTest(String data, int expected) {
        int result = stringCalculator.calculate(data);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사칙연산 통합 계산 테스트")
    void operate() {
        StringCalculatorOperation operation = stringCalculator.getOperation("+");
        stringCalculator.operate(operation, "11");
        assertThat(stringCalculator.getResult()).isEqualTo(11);
    }

    @ParameterizedTest
    @CsvSource(value = {"-11:-11", "11:11", "0:0"}, delimiter = ':')
    @DisplayName("덧셈")
    void add(String value, int expected) {
        stringCalculator.add(value);
        assertThat(stringCalculator.getResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"-11:11", "11:-11", "0:0"}, delimiter = ':')
    @DisplayName("뺄셈")
    void sub(String value, int expected) {
        stringCalculator.sub(value);
        assertThat(stringCalculator.getResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"-11:-22", "11:22", "0:0"}, delimiter = ':')
    @DisplayName("곱셈")
    void mul(String value, int expected) {
        stringCalculator.setResult(2);
        stringCalculator.mul(value);
        assertThat(stringCalculator.getResult()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:4", "4:5", "1:20", "10:2"}, delimiter = ':')
    @DisplayName("나눗셈 - 결과값이 정수로 떨어지는 경우로 한정")
    void div(String value, int expected) {
        stringCalculator.setResult(20);
        stringCalculator.div(value);
        assertThat(stringCalculator.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("사칙연산 기호 구분 및 유효성 검증")
    void getOperation() {
        assertThat(stringCalculator.getOperation("+")).isEqualTo(StringCalculatorOperation.ADD);
        assertThat(stringCalculator.getOperation("-")).isEqualTo(StringCalculatorOperation.SUB);
        assertThat(stringCalculator.getOperation("*")).isEqualTo(StringCalculatorOperation.MUL);
        assertThat(stringCalculator.getOperation("/")).isEqualTo(StringCalculatorOperation.DIV);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.getOperation("!");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.getOperation(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.getOperation("");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.getOperation(" ");
        });
    }

}
