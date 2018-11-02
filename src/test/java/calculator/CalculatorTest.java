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
    public void add(){
        System.out.println("test");
        int result = Calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }


    @Test
    public void add2() {
      System.out.println("add2");
    }
}