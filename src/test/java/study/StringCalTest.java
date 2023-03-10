package study;

import static org.assertj.core.api.Assertions.assertThat;

import StringCal.StringCal;
import StringCal.CalculateFunc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalTest {
    StringCal calculator;
    CalculateFunc calFunc;

    @BeforeEach
    public void SetUp(){
        calculator = new StringCal();
        calFunc = new CalculateFunc();
    }

    @Test
    @DisplayName("더하기 테스트")
    void addTest(){

        assertThat(4).isEqualTo(calFunc.add(1,3));
    }

    @Test
    @DisplayName("빼기 테스트")
    void substractTest(){

        assertThat(4).isEqualTo(calFunc.subtract(6,2));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplyTest(){

        assertThat(4).isEqualTo(calFunc.multiply(2,2));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divideTest(){

        assertThat(0).isEqualTo(calFunc.divide(8,0));
    }

    @Test
    @DisplayName("문자열 나눠주기")
    void seperate(){
        String str = "1 + 3";
        String[] result = {"1" , "+", "3"};
        assertThat(result).isEqualTo(calculator.seperate(str));

    }

    @Test
    @DisplayName("문자열 계산하기")
    void strCal(){
        String str = "1 * 8 + 5";
        assertThat(13).isEqualTo(calculator.calculateString(str));
    }

}
