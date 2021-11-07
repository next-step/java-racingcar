package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("2단계 - 문자열 계산기 - enum Operator 테스트")
class OperatorTest {

    @Test
    @DisplayName("사칙연산 예외 기호 테스트")
    void of() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Operator.of("^");
        });
    }
}