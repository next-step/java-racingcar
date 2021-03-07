package study;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorTest {

    @Test
    @DisplayName("더하기를 테스트하는 함수")
    void 덧셈() {
        int leftValue = 2;
        int rightValue = 3;
        Operations operation = Operations.PLUS;
        assertThat(operation.calculate(leftValue,rightValue)).isEqualTo(5);
    }

    @Test
    @DisplayName("빼기를 테스트하는 함수")
    void 뺄셈() {
        int leftValue = 2;
        int rightValue = 3;
        Operations operation = Operations.MINUS;
        assertThat(operation.calculate(leftValue,rightValue)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱하기를 테스트하는 함수")
    void 곱하기() {
        int leftValue = 2;
        int rightValue = 3;
        Operations operation = Operations.MULTIPLY;
        assertThat(operation.calculate(leftValue,rightValue)).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기를 테스트하는 함수")
    void 나누기() {
        int leftValue = 4;
        int rightValue = 2;
        Operations operation = Operations.DIVIDE;
        assertThat(operation.calculate(leftValue,rightValue)).isEqualTo(2);
    }

    @Test
    @DisplayName("문자열 연산 테스트")
    void stringCalculate(){
        String input = "2 + 3 * 4 / 2 - 30";
        if(StringValidator.isBlank(input)) throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자입니다.");
        String[] res = input.split(" ");
        for(int i=0;i<res.length;i++){
            if(i % 2 -1 == 0){
                Integer leftOperand = Integer.parseInt(res[i-1]);
                Integer rightOperand = Integer.parseInt(res[i+1]);
                res[i+1] = Operations.valueOf(Operations.findSymbol(res[i])).
                        calculate(leftOperand,rightOperand).toString();
            }
        }
        assertThat(res[res.length-1]).isEqualTo("-20");
    }


    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""," "})
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 테스트")
    void returnIllegalArgumentExceptionIfNullOrEmpty(String input){
        assertTrue(StringValidator.isBlank(input));
    }

    @Test
    @DisplayName("사칙연산 기호가 아닌 경우 테스트, IllegalArgumentException 발생할 경우 테스트 통과")
    void isFourArithmeticOperations(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            Operations.findSymbol("+");
            Operations.findSymbol("-");
            Operations.findSymbol("*");
            Operations.findSymbol("/");
            Operations.findSymbol("%");
        });

    }

}
