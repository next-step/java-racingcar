package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static study.calculator.Common.*;

public class CalculatorTest {

    @DisplayName("변수 두개를 제공받아서 더하기 결과값 테스트.")
    @Test
    void plusTest() {
        assertThat(Calculator.plus(1, 2)).isEqualTo(3);
    }

    @DisplayName("변수 두개를 제공받아서 빼기 결과값 테스트.")
    @Test
    void minusTest() {
        assertThat(Calculator.minus(2, 1)).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 곱하기 결과값 테스트.")
    @Test
    void multiplyTest() {
        assertThat(Calculator.multiply(2, 3)).isEqualTo(6);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(몫) 결과값 테스트.")
    @Test
    void divisionShareTest() {
        assertThat(Calculator.divisionShare(2, 2)).isEqualTo(1);
    }

    @DisplayName("변수 두개를 제공받아서 나누기(나머지) 결과값 테스트.")
    @Test
    void divisionRemainderTest() {
        assertThat(Calculator.divisionRemainder(3, 1)).isEqualTo(0);
    }

    @DisplayName("변수가 null이거나 빈값인지 확인 후 IllegalArgumentException throw Test")
    @Test
    void valueIsNullOrBlankTest() {
        //null이 들어간 경우,
        assertThrows(IllegalArgumentException.class, ()-> checkValue(null));
        //빈 값이 들어간 경우,
        assertThrows(IllegalArgumentException.class, ()-> checkValue(""));
        //빈 공간값이 들어간 경우,
        assertThrows(IllegalArgumentException.class, ()-> checkValue(" "));
    }
}
