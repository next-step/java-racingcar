package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("변수 두개를 제공받아서 더하기 결과값 테스트.")
    @Test
    void plusTest() {
        int result = Calculator.plus(1,2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("변수 두개를 제공받아서 빼기 결과값 테스트.")
    @Test
    void minusTest() {
        int result = Calculator.minus(2,1);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 곱하기 결과값 테스트.")
    @Test
    void multiplyTest() {
        int result = Calculator.multiply(2,3);
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(몫) 결과값 테스트.")
    @Test
    void divisionShareTest() {
        int result = Calculator.divisionShare(2,2);
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(나머지) 결과값 테스트.")
    @Test
    void divisionRemainderTest() {
        int result = Calculator.divisionRemainder(3,1);
        assertThat(result).isEqualTo(0);
    }
}
