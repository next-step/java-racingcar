package calculator;

import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("calculate 함수의 Operator method 호출 횟수 테스트")
    void calcuateMocked() {
        Operator mockedOperator = Mockito.mock(Operator.class);
        Calculator mockedCalc = new Calculator(mockedOperator);

        mockedCalc.calculate("2 + 3");
        Mockito.verify(mockedOperator, Mockito.times(1)).add(2, 3);
        Mockito.verify(mockedOperator, Mockito.never()).subtract(2, 3);
        Mockito.verify(mockedOperator, Mockito.never()).multiply(2, 3);
        Mockito.verify(mockedOperator, Mockito.never()).divide(2, 3);

        mockedCalc.calculate("2 + 3 * 4 / 2");
        Mockito.verify(mockedOperator, Mockito.times(2)).add(2, 3);
        Mockito.verify(mockedOperator, Mockito.never()).subtract(2, 3);
        Mockito.verify(mockedOperator, Mockito.times(1)).multiply(0, 4);
        Mockito.verify(mockedOperator, Mockito.times(1)).divide(0, 2);
    }

    @Test
    @DisplayName("calculate 함수 정상적인 케이스")
    void calculateSuccess() {
        assertThat(calculator.calculate("2 + 3"))
                .isEqualTo(5);
        assertThat(calculator.calculate("2 + 3 * 4"))
                .isEqualTo(20);
        assertThat(calculator.calculate("2 + 3 * 4 / 2"))
                .isEqualTo(10);
    }

    @Test
    @DisplayName("calculate 함수 실패하는 케이스")
    void calculateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate(null);
                }).withMessageMatching(Const.NULL_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("");
                }).withMessageMatching(Const.EMPTY_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2");
                }).withMessageMatching(Const.LESS_THAN_3_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2 + 3 *");
                }).withMessageMatching(Const.ODD_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    calculator.calculate("2 # 3 $ 4");
                }).withMessageMatching(Const.BAD_OPERATOR_ERROR_MSG);
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> {
                    calculator.calculate("a + b - c");
                });
    }
}
