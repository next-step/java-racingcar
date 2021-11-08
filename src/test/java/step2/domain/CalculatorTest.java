package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalculatorTest {

    public Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = Calculator.create();
    }

    @Test
    void 계산기를_생성한다() {
        //given
        //when & then
        assertNotNull(calculator);
    }

    @Test
    void 수식을_입력한다() {
        //given
        String value = "5 + 2 - 1";
        //when
        calculator.input(Formula.of(value));
        //then
        assertThat(calculator.isFormulaEmpty()).isFalse();
    }

    @Test
    void 수식을_계산한다() {
        //given
        String value = "2 + 3 * 4 / 2";
        calculator.input(Formula.of(value));
        //when
        int result = calculator.calculate();
        //then
        assertEquals(result, 10);
    }

}
