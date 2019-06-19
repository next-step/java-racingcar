package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MathTest {

    @DisplayName("sign과 인자 값으로 결과 값 테스트")
    @Test
    void createFor() {
        assertThat(Math.getBySignAndCalculate(1L, "*", 4L).equals("4"));
        assertThat(Math.getBySignAndCalculate(1L, "+", 4L).equals("5"));
        assertThat(Math.getBySignAndCalculate(4L, "-", 1L).equals("3"));
        assertThat(Math.getBySignAndCalculate(4L, "/", 1L).equals("4"));
    }

}
