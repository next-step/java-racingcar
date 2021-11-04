package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    void of(String sign) {
        Operator operator = Operator.of(sign);
        assertThat(operator.equals(sign)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"plus", "x", "1"})
    void ofFail(String sign) {
        assertThatThrownBy(() -> Operator.of(sign))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("%s는 사칙연산 기호가 아닙니다.", sign);
    }

}
