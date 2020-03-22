import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {



    @DisplayName("더하기 테스트")
    @Test
    void plus() {
        assertThat(Calculator.plus(1, 2)).isEqualTo(3);
    }

    @DisplayName("빼기 테스트")
    @Test
    void minus() {
        assertThat(Calculator.minus(2, 1)).isEqualTo(1);
    }

    @DisplayName("곱하기 테스트")
    @Test
    void multiple() {
        assertThat(Calculator.multiple(1, 2)).isEqualTo(2);
    }

    @DisplayName("나누기 테스트")
    @Test
    void divide() {
        assertThat(Calculator.divide(2, 1)).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("빈값 테스트")
    void validate(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           Calculator.validate(expression);
        });
    }

}
