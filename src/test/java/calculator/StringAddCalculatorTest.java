package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    private StringAddCalculator stringAddCalculator;

    @Before
    public void setup() {
        stringAddCalculator = new StringAddCalculator();
    }


    @Test
    public void 널체크() {
        int reuslt = stringAddCalculator.add(null);
        assertThat(reuslt).isEqualTo(0);
    }

    @Test
    public void 빈문자열체크() {
        int reuslt = stringAddCalculator.add("");
        assertThat(reuslt).isEqualTo(0);
    }

    @Test
    public void 문자열하나체크() {
        int result = stringAddCalculator.add("2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 컴마체크() {
        int result = stringAddCalculator.add("2,1");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 컴마_또는_콜론_체크() {
        int result = stringAddCalculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 커스텀체크() {
        int result = stringAddCalculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수체크() throws IllegalArgumentException {
        stringAddCalculator.add("-1,2,3");
    }
}
