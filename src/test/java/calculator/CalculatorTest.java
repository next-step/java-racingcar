package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {


    @DisplayName("문자열로 들어온 덧셈 연산식을 계산하는 테스트")
    @Test
    void addTest(){
        // given
        String express = "2 + 3";
        Calculator calculator = new Calculator();

        // when
        int result = calculator.calculate(express);

        // then
        assertThat(result).isEqualTo(5);
    }

}