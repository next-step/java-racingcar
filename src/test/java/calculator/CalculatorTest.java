package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 기본구분자만포함했을때_파싱성공() {
        // given
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2,3";
        String input4 = "1,2:3";

        // when
        String[] result1 = Calculator.parse(input1);
        String[] result2 = Calculator.parse(input2);
        String[] result3 = Calculator.parse(input3);
        String[] result4 = Calculator.parse(input4);

        // then
        assertThat(result1).isEqualTo(new String[]{""});
        assertThat(result2).isEqualTo(new String[]{"1", "2"});
        assertThat(result3).isEqualTo(new String[]{"1", "2", "3"});
        assertThat(result4).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 커스텀구분자만포함할때_파싱성공() {
        // given
        String input1 = "//;\n1;2;3";

        // when
        String[] result1 = Calculator.parse(input1);

        // then
        assertThat(result1).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    void 숫자가아닌문자를포함할때_파싱실패_RuntimeException발생() {
        // given
        String input1 = "hello";
        String input2 = "-1,2,3";

        // when & then
        assertThatThrownBy(() -> Calculator.parse(input1)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> Calculator.parse(input2)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 올바른문자열일때_계산성공() {
        // given
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2,3";
        String input4 = "1,2:3";
        String input5 = "//;\n1;2;3";

        // when
        int result1 = Calculator.sum(input1);
        int result2 = Calculator.sum(input2);
        int result3 = Calculator.sum(input3);
        int result4 = Calculator.sum(input4);
        int result5 = Calculator.sum(input5);

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(6);
        assertThat(result5).isEqualTo(6);
    }
}
