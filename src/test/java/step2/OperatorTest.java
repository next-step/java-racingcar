package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @DisplayName("연산자 유효성 검증 단위테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1",
            "as",
            "x",
            "!",
            " "
    })
    public void test(String factor) {
        assertThatThrownBy(() -> {
            new Operator(factor);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
