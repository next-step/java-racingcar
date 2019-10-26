package calc;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputCheckerTest {
    @Test
    void 입력값이_null테스트() {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(null);
        });
    }

    @Test
    void 입력값이_공백테스트() {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(" ");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 -", "1 + 2 +", "1 + 3 + "})
    void 입력값개수_짝수테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3", "1 ; 2", "+ 3 + ", "1+2+3", "1+ 2 + 3"})
    void 입력값_형식테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 \\ 3", "1 ~ 2", "% 3 + "})
    void 입력값_비허용연산자테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy( () -> {
            new InputChecker(input);
        });
    }
}