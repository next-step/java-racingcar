package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @Test
    void 기본구분자만포함했을때_파싱성공() {
        // given
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2,3";
        String input4 = "1,2:3";

        // when
        String[] result1 = Parser.parse(input1);
        String[] result2 = Parser.parse(input2);
        String[] result3 = Parser.parse(input3);
        String[] result4 = Parser.parse(input4);

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
        String[] result1 = Parser.parse(input1);

        // then
        assertThat(result1).isEqualTo(new String[]{"1", "2", "3"});
    }

    @ParameterizedTest(name = "숫자가아닌문자를포함할때_파싱실패_RuntimeException발생[{arguments}]")
    @ValueSource(strings = {"hello", "-1,2,3"})
    void 숫자가아닌문자를포함할때_파싱실패_RuntimeException발생(String input) {
        assertThatThrownBy(() -> Numbers.of(Parser.parse(input))).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "범위밖숫자입력시_파싱실패_RuntimeException발생[{arguments}]")
    @ValueSource(strings = {"123123123123123"})
    void 범위밖숫자입력시_파싱실패_RuntimeException발생(String input) {
        assertThatThrownBy(() -> Numbers.of(Parser.parse(input))).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "계산결과가정수범위를벗어날때_계산실패_RuntimeException발생[{arguments}]")
    @ValueSource(strings = {"1000000000:1000000000:1000000000"})
    void 계산결과가정수범위를벗어날때_계산실패_RuntimeException발생(String input) {
        assertThatThrownBy(() -> Calculator.sum(input)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 올바른문자열일때_계산성공() {
        // given
        String input1 = "";
        String input2 = "1,2";
        String input3 = "1,2,3";
        String input4 = "1,2:3";
        String input5 = "//;\n1;2;3";
        String input6 = null;
        String input7 = "1";


        // when
        int result1 = Calculator.sum(input1);
        int result2 = Calculator.sum(input2);
        int result3 = Calculator.sum(input3);
        int result4 = Calculator.sum(input4);
        int result5 = Calculator.sum(input5);
        int result6 = Calculator.sum(input6);
        int result7 = Calculator.sum(input7);

        // then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(3);
        assertThat(result3).isEqualTo(6);
        assertThat(result4).isEqualTo(6);
        assertThat(result5).isEqualTo(6);
        assertThat(result6).isEqualTo(0);
        assertThat(result7).isEqualTo(1);
    }
}
