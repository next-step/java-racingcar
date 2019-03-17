package calculator.ver2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StringAdditionCalculatorTest {
    @Test
    public void add_null_또는_빈문자() {
        assertThat(StringAdditionCalculator.calculate(null).getNumber(), is(0));
        assertThat(StringAdditionCalculator.calculate("").getNumber(), is(0));
    }

    @Test
    public void add_숫자하나() {
        assertThat(StringAdditionCalculator.calculate("5").getNumber(), is(5));
    }

    @Test
    public void add_쉼표() {
        assertThat(StringAdditionCalculator.calculate("1,2").getNumber(), is(3));
    }

    @Test
    public void add_쉼표와_콜론() {
        assertThat(StringAdditionCalculator.calculate("1,2:3").getNumber(), is(6));
    }

    @Test
    public void add_커스텀구분자() {
        assertThat(StringAdditionCalculator.calculate("//%\n1%2%3%4").getNumber(), is(10));
    }

    @Test(expected = RuntimeException.class)
    public void add_숫자이외() throws Exception {
        StringAdditionCalculator.calculate("1,히히").getNumber();
    }

    @Test(expected = RuntimeException.class)
    public void add_음수() throws Exception {
        StringAdditionCalculator.calculate("1,-1").getNumber();
    }
}