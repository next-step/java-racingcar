package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.Operator.*;


class OperatorTest {

    @ParameterizedTest
    @DisplayName("플러스 연산 값이 올바르게 출력되는지 확인")
    @CsvSource(value = {"2:3:5", "100:99:199", "20:35:55"}, delimiter = ':')
    public void plus(int a, int b, int expected) {
        int result = PLUS.operate(a, b);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("마이너스 연산 값이 올바르게 출력되는지 확인")
    @CsvSource(value = {"2:3:-1", "100:99:1", "20:35:-15"}, delimiter = ':')
    public void minus(int a, int b, int expected) {
        int result = MINUS.operate(a, b);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("곱하기 연산 값이 올바르게 출력되는지 확인")
    @CsvSource(value = {"2:3:6", "100:99:9900", "20:35:700"}, delimiter = ':')
    public void multiply(int a, int b, int expected) {
        int result = MULTIPLY.operate(a, b);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("곱하기 연산 값이 올바르게 출력되는지 확인")
    @CsvSource(value = {"6:3:2", "100:10:10", "20:4:5"}, delimiter = ':')
    public void divide(int a, int b, int expected) {
        int result = DIVIDE.operate(a, b);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 올바른 경우")
    @CsvSource(value = {"*", "-", "/", "+"})
    public void withSign_success(final String sign) {
        Operator operator = withSign(sign);
    }

    @ParameterizedTest
    @DisplayName("사칙 연산 기호가 올바르지 않은 경우")
    @CsvSource(value = {"!", "=", "(", "^"})
    public void withSign_fail(final String sign) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator operator = withSign(sign);
        });
    }
}
