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


    @Test
    public void 쉼표_콜론_복합_덧셈() {
        // given
        String expression = "1,2:3,4:5";

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 커스텀_구분자_덧셈() {
        // given
        String expression = "//;\n1;2;3";

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 숫자_배열의_합_구하기() {
        // given
        int[] ints = {1, 2, 3};

        //when
        int sum = StringAdder.sum(ints);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @Test
    public void 문자열_null일_때_0_반환() {
        // given
        String expression = null;

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 문자열_비었을_때_0_반환() {
        // given
        String expression = "";

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 문자열_공백일_때_0_반환() {
        // given
        String expression = "  ";

        // when
        int result = StringAdder.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }
}
