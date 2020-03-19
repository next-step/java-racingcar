package calculator.operand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @DisplayName("숫자 객체 생성을 성공한다.")
    @Test
    void create() {
        // given
        final int expect = 1;

        // when
        Number actual = Number.intValueOf("1");

        // then
        assertThat(actual).isNotNull();
        assertThat(actual.getValue()).isEqualTo(expect);
    }

    @DisplayName("숫자 형식 체크를 성공한다.")
    @Test
    void isNumber() {
        // given
        final String input = "2";

        // when
        final boolean actual = Number.isNumber(input);

        // then
        assertThat(actual).isTrue();
    }
}