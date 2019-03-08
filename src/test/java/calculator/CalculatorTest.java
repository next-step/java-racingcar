package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("테스트 시작");
    }

    @Test
    public void 덧셈() {
        System.out.println("덧셈");
        int result = Calculator.add(3, 4);
        assertThat(result).isEqualTo(7);
    }

    @Test
    public void 뺄셈() {
        System.out.println("뺼셈");
        int result = Calculator.sub(3, 4);
        assertThat(result).isEqualTo(-1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("테스트 종료");
    }
}
