package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @Test
    @DisplayName("1과 2를 더하기 연산하면 3이 된다")
    public void plus() {
        //given
        int a = 1;
        int b = 2;

        //when
        int answer = Operator.PLUS.operate(a, b);

        //then
        assertThat(answer).isEqualTo(3);
    }

    @Test
    @DisplayName("2에서 1을 빼기 연산하면 1이 된다")
    public void minus() {
        //given
        int a = 2;
        int b = 1;

        //when
        int answer = Operator.MINUS.operate(a, b);

        //then
        assertThat(answer).isEqualTo(1);
    }

    @Test
    @DisplayName("1과 2를 곱하기 연산하면 3이 된다")
    public void times() {
        //given
        int a = 1;
        int b = 2;

        //when
        int answer = Operator.TIMES.operate(a, b);

        //then
        assertThat(answer).isEqualTo(2);
    }

    @Test
    @DisplayName("10에서 2를 나누기 연산하면 5가 된다")
    public void divide() {
        //given
        int a = 10;
        int b = 2;

        //when
        int answer = Operator.DIVIDE.operate(a, b);

        //then
        assertThat(answer).isEqualTo(5);
    }

    @Test
    @DisplayName("잘못된 연산자를 찾으면 예외 발생")
    public void throwExceptionWhenWrongOperator() {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.getOperator("^"));
    }

    @Test
    @DisplayName("0으로 나누면 예외 발생")
    public void throwExceptionWhenDividedByZero() {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.operate(1, 0));
    }
}