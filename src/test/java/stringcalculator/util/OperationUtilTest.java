package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class OperationUtilTest {

    @Test
    @DisplayName("(operate) 두 숫자의 합을 구하기")
    void add() {
        int num1 = 1;
        int num2 = 2;
        String operator = "+";
        int expectedResult = 3;

        int actualResult = OperationUtil.operate(num1, operator, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(operate) 두 숫자의 차를 구하기")
    void subtract() {
        int num1 = 4;
        int num2 = 5;
        String operator = "-";
        int expectedResult = -1;

        int actualResult = OperationUtil.operate(num1, operator, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(operate) 두 숫자의 곱을 구하기")
    void multiply() {
        int num1 = 3;
        int num2 = 2;
        String operator = "*";
        int expectedResult = 6;

        int actualResult = OperationUtil.operate(num1, operator, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(opearte) 두 숫자를 나눈 몫을 구하기")
    void divide() {
        int num1 = 5;
        int num2 = 2;
        String operator = "/";
        int expectedResult = 2;

        int actualResult = OperationUtil.operate(num1, operator, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }

    @Test
    @DisplayName("(operate) 알수없는 연산자(@)가 입력된 경우, 예외를 던진다.")
    void unknown_operator() {
        int num1 = 5;
        int num2 = 2;
        String operator = "@";

        assertThatThrownBy(() -> {
            OperationUtil.operate(num1, operator, num2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("사칙연산 기호가 아닙니다.");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/caculateTest.csv", delimiter = ':')
    @DisplayName("(cacluate) 유저로부터 받은 문자열을 각종 사칙연산을 이용해 계산해 결과를 낸다.")
    void calculate(String userInput, int expectedResult) {

        int actualResult = OperationUtil.calculate(userInput);
        assertThat(actualResult).isEqualTo(expectedResult);
    }


}