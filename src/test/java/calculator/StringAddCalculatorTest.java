package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Before
    public void setUp() {
    }

    @Test
    public void 빈문자열_또는_NULL_입력() {
       assertThat(new StringAddCalculator().add("")).isEqualTo(0);
        assertThat(new StringAddCalculator().add(null)).isEqualTo(0);
    }

    @Test
    public void 숫자_하나(){
        assertThat(new StringAddCalculator().add("1")).isEqualTo(1);
    }

    @Test
    public void 숫자두개() {
        assertThat(new StringAddCalculator().add("2,3")).isEqualTo(5);
        assertThat(new StringAddCalculator().add("2:3")).isEqualTo(5);
    }

    @Test
    public void 숫자세개이상() {
        assertThat(new StringAddCalculator().add("2,3:4")).isEqualTo(9);
        assertThat(new StringAddCalculator().add("2:3,1")).isEqualTo(6);
    }

}
