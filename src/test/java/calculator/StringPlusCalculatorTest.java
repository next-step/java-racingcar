package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringPlusCalculatorTest {
    StringPlusCalculator calc = new StringPlusCalculator();

    @Test
    public void 입력_값_빈_문자열_혹은_NULL_일_때_0을_반환() {
        assertThat(calc.add("")).isEqualTo(0);
        assertThat(calc.add(null)).isEqualTo(0);
    }

    @Test
    public void 하나_입력_시_해당숫자_반환() {
        String inputString = "1";
        assertThat(calc.add(inputString)).isEqualTo(1);
    }

    @Test
    public void 컴마_입력_시_두_숫자의_합_반환() {
        String inputString = "1,2";
        assertThat(calc.add(inputString)).isEqualTo(3);
    }

    @Test
    public void 구분자_콜론_사용_가능() {
        String inputString = "1,2:3";
        assertThat(calc.add(inputString)).isEqualTo(6);
    }

    @Test
    public void 커스텀_구분자_지정_가능() {
        String inputString = "//;\n1;2;3";
        assertThat(calc.add(inputString)).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_사용_불가() {
        String inputString = "-1,2,3";
        calc.add(inputString);
    }
}
