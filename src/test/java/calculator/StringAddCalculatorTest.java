package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    public void 쉼표_구분자로_더하기() {
        assertThat(StringAddCalculator.add("3,5,7")).isEqualTo(15);
    }


    @Test
    public void 콜론_구분자로_더하기() {
        assertThat(StringAddCalculator.add("3:5:7")).isEqualTo(15);
    }

    @Test
    public void 콜론과_쉼표_구분자로_더하기() {
        assertThat(StringAddCalculator.add("3:5,7")).isEqualTo(15);
    }

    @Test
    public void 커스텀_구분자로_더하기() {
        assertThat(StringAddCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    public void 숫자_하나만_전달하기() {
        assertThat(StringAddCalculator.add("5")).isEqualTo(5);
    }

    @Test(expected = RuntimeException.class)
    public void 음수를_전달하는경우_예외발생() {
        StringAddCalculator.add("-1");
    }

    @Test(expected = RuntimeException.class)
    public void 숫자가아닌값_전달하는경우_예외발생() {
        StringAddCalculator.add("test");
    }
}