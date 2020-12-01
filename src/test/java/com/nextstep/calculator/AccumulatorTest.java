package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AccumulatorTest {

    @DisplayName("Accumulator 클래스의 동작 확인")
    @Test
    public void accumulate(){
        Accumulator accumulator = new Accumulator(10);
        accumulator.calculate("+", 5);
        assertThat(accumulator.getValue()).isEqualTo(15);

        accumulator.calculate("-", 5);
        assertThat(accumulator.getValue()).isEqualTo(10);

        accumulator.calculate( "*", 3);
        assertThat(accumulator.getValue()).isEqualTo(30);

        accumulator.calculate("/", 6);
        assertThat(accumulator.getValue()).isEqualTo(5);
    }

    @DisplayName("연산자가 올바르지 않은 경우 예외처리")
    @Test
    public void operatorException(){
        Accumulator accumulator = new Accumulator(10);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> accumulator.calculate("@", 10))
                .withMessage("@ is not valid operator ( +, -, *, / )");
    }
}
