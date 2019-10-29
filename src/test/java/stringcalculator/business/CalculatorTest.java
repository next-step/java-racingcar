package stringcalculator.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    private Calculator calculator;
    private CentralProcessingUnit cpu;
    private Memory memory;

    @BeforeEach
    void setUp() {
        cpu = new CentralProcessingUnit();
        memory = new Memory();
        calculator = new Calculator(cpu, memory);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "      "})
    void input_ShouldReturnIllegalArgumentExceptionForEmptyString(String expression) {
        assertThatThrownBy(() -> {
            calculator.input(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    void input_ShouldReturnIllegalArgumentExceptionForNull(String expression) {
        assertThatThrownBy(() -> {
            calculator.input(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 ! 4 . 3 & 2 @ 3"})
    void input_ShouldReturnIllegalArgumentExceptionForWrongOperator(String expression) {
        assertThatThrownBy(() -> {
            calculator.input(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 - 3 / 2 * 3"})
    void input(String expression) {

        calculator.input(expression);

        Stack<Operand> operands = memory.getOperands();
        Stack<Operator> operators = memory.getOperators();

        Set<Integer> operandsSet = operands.stream().map(Operand::getValue).collect(Collectors.toSet());
        Set<String> operatorsSet = operators.stream().map(Operator::getValue).collect(Collectors.toSet());

        assertThat(operandsSet).contains(2);
        assertThat(operandsSet).contains(3);
        assertThat(operandsSet).contains(4);
        assertThat(operandsSet).contains(5);
        assertThat(operatorsSet).contains("+");
        assertThat(operatorsSet).contains("-");
        assertThat(operatorsSet).contains("*");
        assertThat(operatorsSet).contains("/");
    }

    @ParameterizedTest
    @ValueSource(strings = {"5 + 4 - 3 * 2 / 3"})
    void calculate(String expression) {
        calculator.input(expression);
        int result = calculator.calculate();
        assertThat(result).isEqualTo(4);
    }
}
