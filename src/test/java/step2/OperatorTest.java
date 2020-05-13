package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    public void plusTest(){

        // given
        int num1 = 6;
        int num2 = 3;

        // when
        int result = Operator.PLUS.operate(num1, num2);

        // then
        assertThat(result).isEqualTo(9);
    }

    @Test
    public void minusTest() {

        // given
        int num1 = 6;
        int num2 = 3;

        // when
        int result = Operator.MINUS.operate(num1, num2);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void multipleTest() {

        // given
        int num1 = 6;
        int num2 = 3;

        // when
        int result = Operator.MULTIPLE.operate(num1, num2);

        // then
        assertThat(result).isEqualTo(18);
    }

    @Test
    public void divideTest() {

        // given
        int num1 = 6;
        int num2 = 3;

        // when
        int result = Operator.DIVIDE.operate(num1, num2);

        // then
        assertThat(result).isEqualTo(2);
    }
}
