package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionTest {

    @Test
    @DisplayName("계산 메서드 기능 테스트 : 1 + 2 = 3")
    public void calculate() {
        //given
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        List<Operator> operators = new ArrayList<>();
        operators.add(Operator.PLUS);
        Expression expression = new Expression(numbers, operators);

        //when
        int result = expression.calculate();

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("잘못된 입력시 예외 발생")
    public void throwExceptionWhenThereIsWrongInput() {
        //given
        List<Integer> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Expression(numbers, operators));
    }
}