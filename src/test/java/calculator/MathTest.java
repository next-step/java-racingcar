package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @DisplayName("덧셈에 대한 테스트")
    @Test
    void addition() {
        // given and expect
        assertThat(Math.ADDITION.calculate(2L, 3L)).isEqualTo(5L);
    }

    @DisplayName("뺄셈에 대한 테스트")
    @Test
    void subtraction() {
        // given and expect
        assertThat(Math.SUBTRACTION.calculate(5L, 3L)).isEqualTo(2L);
    }

    @DisplayName("곱셈에 대한 테스트")
    @Test
    void multiplication() {
        // given and expect
        assertThat(Math.MULTIPLICATION.calculate(5L, 4L)).isEqualTo(20L);
    }

    @DisplayName("나눗셈에 대한 테스트")
    @Test
    void division() {
        // given and expect
        assertThat(Math.DIVISION.calculate(5L, 1L)).isEqualTo(5L);
    }

    @DisplayName("sign으로 Math찾기 테스트")
    @Test
    void createFor() {
        assertThat(Math.createFor("+").equals(Math.ADDITION));
        assertThat(Math.createFor("-").equals(Math.SUBTRACTION));
        assertThat(Math.createFor("*").equals(Math.MULTIPLICATION));
        assertThat(Math.createFor("/").equals(Math.DIVISION));
    }

}
