package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @DisplayName("\"3\"으로 생성하면 값이 3이다 (\"3\" → 3)")
    @Test
    void test_1() {
        assertThat(new PositiveNumber("3").getValue()).isEqualTo(3);
        assertThat(new PositiveNumber("10").getValue()).isEqualTo(10);
    }

    @DisplayName("\"0\"도 허용한다 (\"0\" → 0)")
    @Test
    void test_2() {
        assertThat(new PositiveNumber("0").getValue()).isEqualTo(0);
    }

    @DisplayName("음수이면 RuntimeException (\"-1\")")
    @Test
    void test_3() {
        assertThatThrownBy(() -> new PositiveNumber("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("숫자 이외의 값이면 RuntimeException (\"a\")")
    @Test
    void test_4() {
        assertThatThrownBy(() -> new PositiveNumber("a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값");
    }

}
