package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperandTest {

    @DisplayName("피연산자 유효성 검증 단위테스트")
    @ParameterizedTest
    @ValueSource(strings = { "as", "x", "!"})
    public void test(String factor) {
        assertThatThrownBy(() -> {
            new Operand(factor);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
