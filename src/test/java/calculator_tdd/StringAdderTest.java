package calculator_tdd;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdderTest {
    @Test
    public void 쉼표_덧셈() {
        // given
        String expression = "1,2,3,4";
        
        // when
        int result = StringAdder.calculate(expression);
        
        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 콜론_덧셈() {
        // given
        String expression = "1:2:4";

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(7);
    }
}
