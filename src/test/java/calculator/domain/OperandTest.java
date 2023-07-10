package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class OperandTest {

    @Test
    @DisplayName("Operand를 정상적으로 생성한다.")
    void create() {
        /* given */
        String value = "5";

        /* when & then */
        assertDoesNotThrow(() -> new Operand(value));
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Operand를 생성할 때 빈 문자이라면 0으로 취급한다.")
    void createWithEmptyString(String value) {
        /* given */

        /* when & then */
        Assertions.assertThat(new Operand(value)).isEqualTo(new Operand("0"));
    }

    @ValueSource(strings = {"충규", "-1.1", "1.1"})
    @ParameterizedTest
    @DisplayName("Operand를 생성할 때 정수가 아니라면 IllegalArgumentException을 던진다.")
    void createWithCharacter(String value) {
        /* given */

        /* when & then */
        assertThrowsExactly(IllegalArgumentException.class, () -> new Operand(value));
    }

    @Test
    @DisplayName("Operand를 생성할 때 음수라면 IllegalArgumentException을 던진다.")
    void createWithNegative() {
        /* given */
        String value = "-1";

        /* when & then */
        assertThrowsExactly(IllegalArgumentException.class, () -> new Operand(value));
    }

}