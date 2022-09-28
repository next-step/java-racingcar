package lotto.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("숫자 생성")
    @Test
    void create() {
        assertThat(new Number("1")).isEqualTo(new Number(1L));
    }
}