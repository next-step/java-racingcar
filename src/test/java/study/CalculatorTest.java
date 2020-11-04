package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    private OperatorManager operatorManager;

    // @Test 메소드 실행되기전 수행
    @BeforeEach
    void setUp(){
        operatorManager = new OperatorManager();
        operatorManager.put("+", (a, b) -> a + b);
        operatorManager.put("-", (a, b) -> a - b);
        operatorManager.put("*", (a, b) -> a * b);
        operatorManager.put("/", (a, b) -> a / b);
    }

    @Test
    @DisplayName("정상 테스트")
    void successTest(){
        String input = "2 + 3 * 4 / 2";
        Calculator calculator = new Calculator(operatorManager);
        assertThat(calculator.calculate(input)).isEqualTo(10);
     }
    @Test
    @DisplayName("덧셈")
    void addTest(){
        Operator operator = new Addition();
        assertThat(operator.operate(1,2)).isEqualTo(3);

    }
    @Test
    @DisplayName("뺄셈")
    void subTest(){
        Operator operator = new Subtraction();
        assertThat(operator.operate(3,1)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈")
    void multiTest(){
        Operator operator = new Multiplication();
        assertThat(operator.operate(3,2)).isEqualTo(6);

    }
    @Test
    @DisplayName("나눗셈")
    void divTest(){
        Operator operator = new Division();
        assertThat(operator.operate(3,1)).isEqualTo(3);

    }
    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    void argTest(){
        String input = "";
        Calculator calculator = new Calculator(operatorManager);
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.calculate(input);
        });
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌경우")
    void operatorTest(){
        String input = "1 @ 3";
        Calculator calculator = new Calculator(operatorManager);
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.calculate(input);
        });

    }

}
