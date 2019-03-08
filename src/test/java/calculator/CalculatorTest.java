package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Before
    public void setUp() throws Exception {  // 초기화
        System.out.println("setUp");
    }

    @Test
    public void 덧셈() {
        int result = Calculator.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 뺄셈() {
        int result = Calculator.subtract(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @After
    public void tearDown() throws Exception {   // 후처리
        System.out.println("tearDown");
    }
    // 테스트 간 의존관계를 두면 안됨, 메소드 실행 순서는 랜덤이므로
}
