package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("2단계 - 문자열 계산기 - enum Operator 테스트")
class OperatorTest {

    @Test
    @DisplayName("연산자 정상 시나리오")
    void of() {
        assertThat(Operator.of("+"))
                .isEqualTo(Operator.ADDITION);
        assertThat(Operator.of("-"))
                .isEqualTo(Operator.SUBTRACTION);
        assertThat(Operator.of("*"))
                .isEqualTo(Operator.MULTIPLICATION);
        assertThat(Operator.of("/"))
                .isEqualTo(Operator.DIVISION);
    }

    @Test
    @DisplayName("연산자 예외 기호 테스트")
    void ofIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Operator.of("^");
        });
    }
}