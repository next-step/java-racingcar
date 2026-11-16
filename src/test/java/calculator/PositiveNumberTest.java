package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveNumberTest {

    @DisplayName("\"3\"으로 생성하면 값이 3이다 (\"3\" → 3)")
    @Test
    void test_1() {
        assertThat(PositiveNumber.valueOf("3")).isEqualTo(PositiveNumber.valueOf(3));
        assertThat(PositiveNumber.valueOf("10")).isEqualTo(PositiveNumber.valueOf(10));
    }

    @DisplayName("\"0\"도 허용한다 (\"0\" → 0)")
    @Test
    void test_2() {
        assertThat(PositiveNumber.valueOf("0")).isEqualTo(PositiveNumber.valueOf(0));
    }

    @DisplayName("음수이면 RuntimeException (\"-1\")")
    @Test
    void test_3() {
        assertThatThrownBy(() -> PositiveNumber.valueOf("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("숫자 이외의 값이면 RuntimeException (\"a\")")
    @Test
    void test_4() {
        assertThatThrownBy(() -> PositiveNumber.valueOf("a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값");
    }

    @DisplayName("int로 생성하면 그 값과 같다 (3 → 3)")
    @Test
    void test_5() {
        assertThat(PositiveNumber.valueOf(3)).isEqualTo(PositiveNumber.valueOf("3"));
        assertThat(PositiveNumber.valueOf(0)).isEqualTo(PositiveNumber.valueOf("0"));
    }

    @DisplayName("int로 생성해도 음수이면 RuntimeException (-1)")
    @Test
    void test_6() {
        assertThatThrownBy(() -> PositiveNumber.valueOf(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @DisplayName("plus하면 두 값의 합과 같다 (3 + 4 → 7)")
    @Test
    void test_7() {
        assertThat(PositiveNumber.valueOf(3).plus(PositiveNumber.valueOf(4))).isEqualTo(PositiveNumber.valueOf(7));
    }

}
