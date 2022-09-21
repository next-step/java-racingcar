package racing.v1.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerInputHandlerTest {
    @Test
    @DisplayName("음수가 입력되면 validation 체크가 false를 반환한다.")
    void step1() {
        assertThat(new IntegerInputHandler().validate("-1")).isFalse();

    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력되면 validation 체크가 false를 반환한다.")
    void step2() {
        assertThat(new IntegerInputHandler().validate("a")).isFalse();
    }

    @Test
    @DisplayName("양수가 입력되면 validation 체크가 false를 반환한다.")
    void step3() {
        assertThat(new IntegerInputHandler().validate("1")).isTrue();
    }
}
