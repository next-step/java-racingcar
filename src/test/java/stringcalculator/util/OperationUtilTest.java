package stringcalculator.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OperationUtilTest {

    @Test
    @DisplayName("(add) 두 숫자의 합을 구하기")
    void add() {
        int num1 = 1;
        int num2 = 2;
        int expectedResult = 3;

        int actualResult = OperationUtil.add(num1, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(subtract) 두 숫자의 차를 구하기")
    void subtract() {
        int num1 = 4;
        int num2 = 5;
        int expectedResult = -1;

        int actualResult = OperationUtil.subtract(num1, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(multiply) 두 숫자의 곱을 구하기")
    void multiply() {
        int num1 = 3;
        int num2 = 2;
        int expectedResult = 6;

        int actualResult = OperationUtil.multiply(num1, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


    @Test
    @DisplayName("(divide) 두 숫자를 나눈 몫을 구하기")
    void divide() {
        int num1 = 5;
        int num2 = 2;
        int expectedResult = 2;

        int actualResult = OperationUtil.divide(num1, num2);

        assertThat(actualResult).isEqualTo(expectedResult);

    }


}