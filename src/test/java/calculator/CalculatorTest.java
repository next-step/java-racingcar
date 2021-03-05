package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("문자열로 들어온 덧셈 연산식을 계산하는 테스트")
    @Test
    void plusTest(){
        // given
        String express = "2 + 3";

        // when
        int result = calculator.calculate(express);

        // then
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("문자열로 들어온 뺄샘 연산식을 계산하는 테스트")
    @Test
    void minusTest(){
        // given
        String express = "5 - 2";

        // when
        int result = calculator.calculate(express);

        // then
        assertThat(result).isEqualTo(3);
    }

}