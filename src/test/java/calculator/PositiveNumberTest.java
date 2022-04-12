package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositiveNumberTest {
    @Test
    void 입력값이_문자인_경우() {
        assertThatThrownBy(() -> {
            new PositiveNumber("a");
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 입력값에_공백이_포함된_경우() {
        assertThatThrownBy(() -> {
            new PositiveNumber("1 ");
        }).isInstanceOf(NumberFormatException.class);
    }
}