package calculator.domain;

import calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorTest {

    @DisplayName("더하기")
    @ParameterizedTest
    @CsvSource(value = {"1,1,2", "1,2,3", "1,6,5", "1,7,8", "1,9,10"})
    void plus(int x, int y, int expected) {
        int result = Operator.PLUS.caculate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("빼기")
    @ParameterizedTest
    @CsvSource(value = {"1,1,0", "1,-1,2", "1,2,-1", "1,4,-3"})
    void minus(int x, int y, int expected) {
        int result = Operator.MINUS.caculate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("곱하기")
    @ParameterizedTest
    @CsvSource(value = {"1,2,2", "1,4,4", "3,4,12"})
    void multiply(int x, int y, int expected) {
        int result = Operator.MULTIPLY.caculate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나누기")
    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "1,2,0"})
    void divide(int x, int y, int expected) {
        int result = Operator.DIVIDE.caculate(x, y);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("0으로 나눌 경우 예외처리")
    void divideZeroException() {
        // given
        int x = 10;
        int y = 0;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.DIVIDE.caculate(x, y);
        })
                .withMessageContaining("0으로 나눌 수 없습니다.");
    }


    @DisplayName("사칙연산 가지고 오기")
    @ParameterizedTest
    @ValueSource(strings = {"!","@","#","$","%","^","&","*","(",")","-","+","PLUS"})
    void valueOfOperator(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Operator.valueOfOperator(input);
        })
                .withMessageContaining("사칙연산 기호가 올바르지 않습니다.");
    }

    @DisplayName("단일 계산")
    @ParameterizedTest
    @CsvSource(value = {"1,+,1,2", "2,*,3,6", "3,/,2,1", "5,/,1,5", "4,+,2,6", "3,*,3,9"})
    void simpleCalulate(int x, String operator, int y, int expected) {
        int result = Operator.valueOfOperator(operator).caculate(x,y);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("복합 계산")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2 / /"})
    void multipleCalulate(String expression){
        String[] expressions = expression.split(" ");
        int sum = Integer.parseInt(expressions[0]);
        for (int i = 0; i < expressions.length-2; i+=2) {
            sum = Operator.valueOfOperator(expressions[i+1]).caculate(sum,Integer.parseInt(expressions[i+2]));
        }
        assertThat(sum).isEqualTo(10);
    }

}
