package step4;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class StringAddCalculatorTest {


    private StringAddCalculator cal;

    @Before
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, cal.add(null));
    }

    @Test
    public void add_한_자릿수_숫자면_그_숫자를_반환() {
        assertEquals(9, cal.add("9"));
    }

    @Test
    public void add_문자열이_숫자면_그_숫자를_반환() {
        assertThat(cal.add("33")).isEqualTo(33);
        assertThat(cal.add("32223")).isEqualTo(32223);
    }

    @Test
    public void add_쉼표구분자() {
        assertThat(cal.add("3,3")).isEqualTo(6);
        assertThat(cal.add("4,4")).isEqualTo(8);
    }


}