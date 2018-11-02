package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Before
    public void setup(){
        //매 메소드마다 초기화(독립적 테스트 가능케해줌)
        System.out.printf("before");
    }

    @Test
    public void add() {
        System.out.println("add");

        int result = Calculator.add(3,5);
        assertThat(result).isEqualTo(7);

    }

    @Test
    public void sub(){

        System.out.printf("sub");
        int result = Calculator.sub(3,5 );
        assertThat(result).isEqualTo(-2);
        assertThat(result).isEqualTo(-1);

    }


}