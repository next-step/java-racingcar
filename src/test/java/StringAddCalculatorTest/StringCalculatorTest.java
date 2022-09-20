package StringAddCalculatorTest;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;



public class StringCalculatorTest {
    private StringCalculator calculator;
    @BeforeEach
    void setUp(){
        calculator  = new StringCalculator();
    }
    @Test
    @DisplayName("null이나 빈 문자를 입력시 0을 반환한다")
    void stringSum_null_또는_빈문자(){
        //given//when
        int result =calculator.stringSum(null);
        //then
        assertThat(result).isEqualTo(0);
        //given//when
        result =calculator.stringSum("");
        //then
        assertThat(result).isEqualTo(0);
    }
    @Test
    @DisplayName("문자열 1을 넣으면 1을 반환한다.")
    void stringSum_숫자하나(){
        //given//when
        int result = calculator.stringSum("1");
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 1,2를 넣으면 ,를 제거하고 합 3을 반환한다.")
    void stringSum_숫자두개(){
        //given//when
        int result = calculator.stringSum("1,2");
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 1,2:3를 넣으면 ,와 : 를제거하고 합 6을 반환한다.")
    void stringSum_숫자_3개_구분자_추가_제거(){
        //given//when
        int result = calculator.stringSum("1,2:3");
        //then
        assertThat(result).isEqualTo(6);
    }
}
