package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringAddCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @Before
    public void init() {
        this.stringAddCalculator = new StringAddCalculator();
    }

    @Test
    public void nullTest() {
        assertThat(this.stringAddCalculator.add(null)).isEqualTo(0);
    }

    @Test
    public void blankTest() {
        assertThat(this.stringAddCalculator.add("")).isEqualTo(0);
        assertThat(this.stringAddCalculator.add("       ")).isEqualTo(0);
    }

    @Test
    public void isNumberTest() throws RuntimeException {
        assertThat(this.stringAddCalculator.isInteger("-1")).isFalse();
        assertThat(this.stringAddCalculator.isInteger("0")).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void isNumberStringTest() throws Exception {
        assertThat(this.stringAddCalculator.isInteger("a")).isFalse();
    }

    @Test
    public void addNumber() {
        assertThat(this.stringAddCalculator.add("1")).isEqualTo(1);
    }

    @Test
    public void restSeparatorTest() {
        assertThat(this.stringAddCalculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    public void colonSeparatorTest() {
        assertThat(this.stringAddCalculator.add("1:2:3")).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void restAndColonSeparatorTest() {
        assertThat(this.stringAddCalculator.add("1,2:u")).isEqualTo(3);
    }

    @Test
    public void isCustomTest() {
        assertThat(this.stringAddCalculator.isCustom("//;\n")).isTrue();
    }

    @Test
    public void customSeparatorTest() {
        assertThat(this.stringAddCalculator.add("//;\n1;2")).isEqualTo(3);
    }

}
