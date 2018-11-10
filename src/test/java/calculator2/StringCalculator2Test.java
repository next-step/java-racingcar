package calculator2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculator2Test {

    @Test
    public void 덧셈_숫자하나() throws Exception {
        int result = StringCalculator2.add("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void 덧셈_쉼표구분자() throws Exception {
        int result = StringCalculator2.add("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 덧셈_쉼표_또는_세미콜론_구분자() throws Exception {
        int result = StringCalculator2.add("1,2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 덧셈_null_또는_빈문자() throws Exception {
        assertThat(StringCalculator2.add(null)).isEqualTo(0);
        assertThat(StringCalculator2.add("")).isEqualTo(0);
    }

    @Test
    public void 덧셈_커스텀_구분자() throws Exception {
        assertThat(StringCalculator2.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void 덧셈_음수() throws Exception {
        StringCalculator2.add("-1,2,3");
    }
}
