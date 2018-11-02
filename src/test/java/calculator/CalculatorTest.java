package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Before
    public void setup() {
        System.out.println("before");
    }

    @Test
    public void add() {
        System.out.println("add");
    }

    @Test
    public void add2() {
        System.out.println("add2");
    }
}