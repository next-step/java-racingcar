package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositiveNumberTest {

    @DisplayName("0 이상 정수형으로 생성 시 정상 작동")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    void createConstructorOfInt(int input) {
        assertDoesNotThrow(() -> new PositiveNumber(input));
    }

    @DisplayName("0 이상 문자열로 생성 시 정상 작동")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "100"})
    void createConstructorOfString(String input) {
        assertDoesNotThrow(() -> new PositiveNumber(input));
    }


    @DisplayName("음수로 생성 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -100})
    void createConstructorWhenInputNegativeThenThrowsException(int input) {
        assertThatThrownBy(() -> new PositiveNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("덧셈 연산")
    @Test
    void add() {
        PositiveNumber numberA = new PositiveNumber("10");
        PositiveNumber numberB = new PositiveNumber("20");

        assertThat(numberA.add(numberB)).isEqualTo(new PositiveNumber("30"));
    }

}
