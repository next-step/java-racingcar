package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    // test 수행순서는 랜덤, 테스트간의 의존성이 존재하면 안됨
    // before, after는 단위테스트 실행마다 호출됨
    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        System.out.println("add");
        int result = Calculator.add(1, 3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈() {
        System.out.println("subtract");
        int result = Calculator.subtract(3, 1);
        assertThat(result).isEqualTo(2);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}
