package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


    /**
     * JUnit은
     * - @Test 메소드는 구현순서대로 실행되지 않음.
     * - @Before 메소드는 매번 초기화 된다
     */

    @Before
    public void setup() {

    }

    @Test
    public void add() {
        int result = Calculator.add(3, 5);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void min() {
        int result = Calculator.min(1, 3);
        assertThat(result).isEqualTo(-2);
    }

    @Test
    public void mul() {
        int result = Calculator.mul(5, 8);
        assertThat(result).isEqualTo(40);
    }

    @Test
    public void div() {
        int result = Calculator.div(10, 5);
        assertThat(result).isEqualTo(2);
    }
}
