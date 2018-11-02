package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CalculatorTest {

    @Before
    public void setup(){
        System.out.println("before");
    }
    //Before는 테스트 실행전 매번 실행
    //테스트의 실행순서는 랜덤임 그래서 테스트사이에 의존성이 있으면 안
    @Test
    public void add() {
        int result = Calculator.add(5,10);
        assertThat(result).isEqualTo(15);
        System.out.println("add");
    }
    @Test
    public void add2(){
        System.out.println("add2");
    }
}
