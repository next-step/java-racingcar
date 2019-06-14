package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @Test
    void add() {
        String sample = "2 + 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculate(sample)).isEqualTo(5);
    }

    @Test
    void subtract() {
        String sample = "2 - 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculate(sample)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        String sample = "2 * 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculate(sample)).isEqualTo(6);
    }

    @Test
    void divide() {
        String sample = "6 / 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculate(sample)).isEqualTo(2);
    }

    @Test
    void multiOperator() {
        String sample = "2 + 3 * 4 / 2";

        Calculator calc = new Calculator();

        assertThat(calc.calculate(sample)).isEqualTo(10);
    }

    class Calculator {
        private int result = 0;

        int calculate(String equation) {
            String[] operList = equation.split(" ");

            int first = toInt(operList[0]);
            result = add(first);

            for (int i = 1; i < operList.length - 1; i++ ) {
                result = operate(operList[i], operList[i+1]);
            }

            return result;
        }

        private int operate(String operator, String operand) {
            if (isNotValidOperator(operator)) {
                return result;
            }

            if (isAddOperator(operator)) {
                return add(toInt(operand));

            } else if (isSubtractOperator(operator)) {
                return subtract(toInt(operand));

            } else if (isMultiplyOperator(operator)) {
                return multiply(toInt(operand));

            } else if (isDivideOperator(operator)) {
                return divide(toInt(operand));

            }

            return 0;
        }

        private boolean isNotValidOperator(String word) {
            return !isValidOperator(word);
        }

        private boolean isValidOperator(String word) {
            return isAddOperator(word)
                    || isSubtractOperator(word)
                    || isMultiplyOperator(word)
                    || isDivideOperator(word);
        }

        private boolean isAddOperator(String word) {
            return word.equals("+");
        }

        private boolean isSubtractOperator(String word) {
            return word.equals("-");
        }

        private boolean isMultiplyOperator(String word) {
            return word.equals("*");
        }

        private boolean isDivideOperator(String word) {
            return word.equals("/");
        }

        private int toInt(String word) {
            return Integer.parseInt(word);
        }

        private int add(int oper) {
            return result + oper;
        }

        private int subtract(int oper) {
            return result - oper;
        }

        private int multiply(int oper) {
            return result * oper;
        }

        private int divide(int oper) {
            return result / oper;
        }
    }
}
