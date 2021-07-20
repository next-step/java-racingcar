package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    @DisplayName("빈값 혹은 null일 경우 에러처리")
    void isEmptyOrNull(){
        String[] emptyArr = new String[]{"","+","3"};
        String[] nullArr = new String[]{null,"+","3"};

        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.checkBeforeCalculate(emptyArr);
        });
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.checkBeforeCalculate(nullArr);
        });
    }


    @ParameterizedTest
    @CsvSource(value = {"2,3,+,5","3,-4,-,7","5,4,*,20","20,2,/,10"})
    @DisplayName("덧셈, 뺄셈, 곱셈, 나눗셈")
    void calculateTest(int number1, int number2, String sign, int result){
        assertThat(stringCalculator.calculate(number1,number2,sign)).isEqualTo(result);
    }

    @Test
    @DisplayName("실행 테스트")
    void excuteTest(){
        String[] arr = new String[]{"2","+","3","*","4","/","2"};
        assertThat(stringCalculator.excute(arr)).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 테스트")
    void calculatorTest(){
        assertThat(stringCalculator.calculator("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    @DisplayName("사칙연산 기호 아닌경우")
    void isCalculateException(){
        assertThatIllegalArgumentException().isThrownBy(()->{
            stringCalculator.calculate(2,3,"??");
        });
    }
}
