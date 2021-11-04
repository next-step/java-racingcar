package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void 수식을_입력_한다() {
        //given
        String formula = "5 + 2 - 1";
        //when
        calculator.input(formula);
        //then
        assertThat(calculator.getFormula()).isEqualTo(formula);
    }

    @Test
    void 수식에_null_값을_입력_하면_IllegalArgumentException_이_발생한다() {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> calculator.input(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "3 +"})
    void 수식에_유효하지_않은_값을_입력_하면_IllegalArgumentException_이_발생한다(String formula) {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> calculator.input(formula));
    }

    @Test
    void 덧셈() {
        //given
        //when
        int result = calculator.plus(1, 2);
        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        //given
        //when
        int result = calculator.subtract(1, 2);
        //then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void 곱셈() {
        //given
        //when
        int result = calculator.multiply(1, 2);
        //then
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 나눗셈() {
        //given
        //when
        int result = calculator.division(1, 2);
        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 나눗셈_예외_테스트() {
        //given
        //when
        //then
        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.division(3, 0));
    }

    @Test
    void 수식을_계산한다1() {
        //given
        calculator.input("2 + 3 * 4 / 2");
        //when
        int result = calculator.calculate();
        //then
        assertEquals(result, 10);
    }

    @Test
    void 유효하지_않은_연산자를_포함하여_계산하면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        calculator.input("2 + 5 * 4 / 2 % 2");
        //then
        assertThrows(IllegalArgumentException.class, calculator::calculate);
    }

    @Test
    void 유효하지_않은_수식을_포함하여_계산하면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        calculator.input("2 + ab * 4 / 2 % 2");
        //then
        assertThrows(IllegalArgumentException.class, calculator::calculate);
    }

    @Test
    void 수식을_입력하지_않고_계산하면_IllegalArgumentException_이_발생한다() {
        //given
        //when
        //then
        assertThrows(IllegalArgumentException.class, calculator::calculate);
    }

}