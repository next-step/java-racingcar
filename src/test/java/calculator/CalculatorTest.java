package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    // test가 실행되기전 항상 실행
    // 실행순서가 랜덤, 테스트간의 의존관계를 가지면 안됨.
    // 테스트를 독립적으로 만들어야 함.
    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    @Test
    public void 덧셈() {
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈() {
        int result = Calculator.substract(2, 1);
        assertThat(result).isEqualTo(1);
    }

    @After
    public void testDown() throws Exception {
        System.out.println("testDown");
    }
}
