package study;

import static org.assertj.core.api.Assertions.assertThat;

import StringCal.StringCal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalTest {
    StringCal calculator;

    @BeforeEach
    public void SetUp(){
        calculator = new StringCal();
    }

    @Test
    @DisplayName("더하기 테스트")
    void addtest(){
        assertThat(4).isEqualTo(calculator.add(1,3));
    }

    @Test
    @DisplayName("빼기 테스트")
    void substracttest(){
        assertThat(4).isEqualTo(calculator.subtract(6,2));
    }

    @Test
    @DisplayName("곱하기 테스트")
    void multiplytest(){
        assertThat(4).isEqualTo(calculator.multiply(2,2));
    }

    @Test
    @DisplayName("나누기 테스트")
    void dividetest(){
        assertThat(0).isEqualTo(calculator.divide(8,0));
    }


    @Test
    @DisplayName("문자열 나눠주기")
    void sep(){
        String str = "1 + 3";
        String[] result = {"1" , "+", "3"};
        assertThat(result).isEqualTo(calculator.seperate(str));

    }

    @Test
    @DisplayName("문자열 계산하기")
    void strcal(){
        String str = "1 * 8 + 5";
        String[] result = calculator.seperate(str);
        int num = 13;
        assertThat(num).isEqualTo(calculator.calculateString(result));
    }
}
