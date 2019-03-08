package calculator;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CalculatorTest
{
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = Calculator.add(1,3);
        assertThat(result).isEqualTo(4);
        //asserThat(result).isEqualTo(4);
    }

    @Test
    public void 뺼셈() {
        int result = Calculator.add(3,1);
        //asserThat(result).isEqualTo(2);
    }

    @After
    public void tearDown() throws Exception
    {
        System.out.println("tearDown");
    }
}
