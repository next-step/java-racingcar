package step2_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();


    @DisplayName("더하기")
    @Test
    void plus(){
        assertThat(calculator.plus(3,1)).isEqualTo(4);
    }
    @DisplayName("빼기")
    @Test
    void minus(){
        assertThat(calculator.minus(3,1)).isEqualTo(2);
    }
    @DisplayName("곱하기")
    @Test
    void multiple(){
        assertThat(calculator.multiple(3,2)).isEqualTo(6);
    }
    @DisplayName("나누기")
    @Test
    void divide(){
        assertThat(calculator.divide(10,3)).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings ={"\0"," ",""})
    void isBlank(String input){
        assertThatIllegalArgumentException().isThrownBy(()->{
            calculator.isBlack(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("IllegalException 발생 하는지 테스트")
    @Test
    void isFourOperations(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    StringCalculator.isFourOperations("3 ^ 5");
                    StringCalculator.isFourOperations("1 +- 5");
                });
    }

    @DisplayName("계산기 잘 작동하니")
    @Test
    void doCalculate(){
        assertThat(calculator.doCalculate("12 + 3 * 4 / 7")).isEqualTo(8);
    }
}
