package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class OperationTest {
    @DisplayName("덧셈을 수행한다.")
    @Test
    void testPlus(){
        int plus = Operation.PLUS.calculate(1, 2);
        assertThat(plus).isEqualTo(3);
//        assertThat(plus).isEqualTo(4);
    }
    @DisplayName("뺄셈을 수행한다.")
    @Test
    void testMinus(){
        int minus = Operation.MINUS.calculate(3, 2);
        assertThat(minus).isEqualTo(1);
    }
    @DisplayName("곱셈을 수행한다.")
    @Test
    void testMuliply(){
        int multiply = Operation.MULTIPLY.calculate(2, 5);
        assertThat(multiply).isEqualTo(10);
    }
    @DisplayName("나눗셈을 수행한다.")
    @Test
    void testDivide(){
        int divide = Operation.DIVIDE.calculate(4, 2);
        assertThat(divide).isEqualTo(2);
        divide = Operation.DIVIDE.calculate(7, 3);
        assertThat(divide).isEqualTo(2);
    }
    @DisplayName("공백 \"\" 을 입력하면 NOTHING 값 출력")
    @Test
    void tesetNull() {
//        assertThat(Operation.of("#")).isNull();
        assertThatThrownBy(() -> {
            Operation.of("X").calculate(1, 2);
        }).hasMessageContaining("연산자가 아닙니다.");
//        assertThat(Operation.NOTHING.calcuate(0,0)).isNull();
    }
    @DisplayName("기호에 맞는 사칙연산 수행")
    @ParameterizedTest
    @CsvSource(value = {"1,2,+:3","3,2,-:1","2,4,*:8","9,3,/:3","10,4,/:2"}, delimiter = ':')
    void calculate(String value, String expected){
        String[] express = value.split(",");
        String operator = express[2];
        int num1 = Integer.valueOf(express[0]);
        int num2 = Integer.valueOf(express[1]);
        assertThat(Operation.of(operator).calculate(num1, num2)).isEqualTo(Integer.valueOf(expected));
    }

    @DisplayName("0으로 나눈 경우 에러처리")
    @Test
    void divideByZero(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> Operation.DIVIDE.calculate(10,0)
        ).withMessageContaining("Can't divide");
    }
}