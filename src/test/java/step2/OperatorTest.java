package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step2 - 연산자 테스트")
class OperatorTest {

    int num1 = 10;
    int num2 = 5;

    @DisplayName("더하기")
    @Test
    void add() {
        int result = Operator.add(num1, num2);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("빼기")
    @Test
    void sub() {
        int result = Operator.sub(num1, num2);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("곱하기")
    @Test
    void mul() {
        int result = Operator.mul(num1, num2);
        assertThat(result).isEqualTo(50);
    }

    @DisplayName("나누기")
    @Test
    void div() {
        int result = Operator.div(num1, num2);
        assertThat(result).isEqualTo(2);
    }
}