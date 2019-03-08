package calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    //테스트에 필요한 중복적인 작업 코드
    //alt + insert -> setup  => before method 생성됨

    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
    }

    //테스트간에 의존관계 가지면 안됨
    //테스트 method는 위에 있다고 해서 먼저 실행되고 그런거 없음
    //그러니까 순차적으로 단계 테스트를 method별로 만들고 그러면 안된다.
    @Test
    public void 덧셈() {
        System.out.println("add");
        int result = Calculator.add(1,3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 뺄셈() {
        System.out.println("sub");
        int result = Calculator.subtract(1,3);
        assertThat(result).isEqualTo(-2);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }
}
