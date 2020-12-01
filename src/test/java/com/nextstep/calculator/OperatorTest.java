package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {

    @DisplayName("연산자가 올바르지 않은 경우 Operator null 반환")
    @Test
    public void getOperator() {
        Operator operator = Operator.select("#");
        assertThat(operator).isNull();
    }

    @DisplayName("연산자에 따른 Operator 획득 및 계산 결과")
    @ParameterizedTest
    @CsvSource({"1,+,2,3", "3,-,1,2", "4,*,3,12", "10,/,2,5"})
    public void calculate(int a, String symbol, int b, int expected) {
        Operator operator = Operator.select(symbol);
        int result = operator.apply(a,b);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("나누어 떨어지지 않는 숫자가 주어진 경우 예외처리")
    @Test
    public void divisionException() {
        Operator operator = Operator.DIVISION;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> operator.apply(3,5)).withMessage("3 can't divided into 5");
    }

}
