package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("IntegerFormulaNodeOperator")
class IntegerFormulaNodeOperatorFactoryTest {
    @Test
    @DisplayName("handle PLUS")
    void plus() {
        final FormulaNodeOperator<Integer> operator = IntegerFormulaNodeOperatorFactory.plus();
        final FormulaNodeValue<Integer> resultValue = operator.operate(IntegerFormulaNodeValue.ONE,
                                                                       IntegerFormulaNodeValue.TWO);

        assertThat(resultValue.asInt()).isEqualTo(3);
    }

    @Test
    @DisplayName("throw exception when occurred overflow in PLUS")
    void plusRaiseException() {
        final FormulaNodeOperator<Integer> operator = IntegerFormulaNodeOperatorFactory.plus();

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> operator.operate(new IntegerFormulaNodeValue(Integer.MAX_VALUE),
                                                   new IntegerFormulaNodeValue(1)));
    }

    @Test
    @DisplayName("handle PLUS even when overflow occurred")
    void plusIgnoreOverflow() {
        final FormulaNodeOperator<Integer> operator = IntegerFormulaNodeOperatorFactory.plusIgnoreOverflow();

        final FormulaNodeValue<Integer> resultValue = operator.operate(new IntegerFormulaNodeValue(Integer.MAX_VALUE),
                                                                       new IntegerFormulaNodeValue(1));

        assertThat(resultValue.asInt()).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    @DisplayName("throw exception when occurred overflow in DIVIDE")
    void divide() {
        final FormulaNodeOperator<Integer> operator = IntegerFormulaNodeOperatorFactory.divide();

        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> operator.operate(IntegerFormulaNodeValue.ONE,
                                                   IntegerFormulaNodeValue.ZERO));
    }

    @Test
    @DisplayName("handle DIVIDE even when exception occurred")
    void divideIgnoreException() {
        final int valueWhenExceptionOccurred = 123;
        final FormulaNodeOperator<Integer> operator = IntegerFormulaNodeOperatorFactory
                .divideIgnoreException(valueWhenExceptionOccurred);
        final FormulaNodeValue<Integer> resultValue = operator.operate(IntegerFormulaNodeValue.ONE,
                                                                       IntegerFormulaNodeValue.ZERO);

        assertThat(resultValue.asInt()).isEqualTo(123);
    }
}