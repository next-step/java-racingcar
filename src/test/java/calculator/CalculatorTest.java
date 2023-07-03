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
}
