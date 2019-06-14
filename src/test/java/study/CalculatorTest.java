package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @Test
    void add() {
        String sample = "2 + 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculation(sample)).isEqualTo(5);
    }

    @Test
    void subtract() {
        String sample = "2 - 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculation(sample)).isEqualTo(-1);
    }

    @Test
    void multiply() {
        String sample = "2 * 3";

        Calculator calc = new Calculator();

        assertThat(calc.calculation(sample)).isEqualTo(6);
    }

    class Calculator {
        int result = 0;

        int calculation(String equation) {
            String[] operList = equation.split(" ");

            if (isAddOperator(operList[1])) {
                int oper1 = parseInt(operList[0]);
                int oper2 = parseInt(operList[2]);

                result = add(oper1);
                result = add(oper2);
            } else if (isSubtractOperator(operList[1])) {
                int oper1 = parseInt(operList[0]);
                int oper2 = parseInt(operList[2]);

                result = add(oper1);
                result = subtract(oper2);
            } else if (isMultiplyOperator(operList[1])) {
                int oper1 = parseInt(operList[0]);
                int oper2 = parseInt(operList[2]);

                result = add(oper1);
                result = multiply(oper2);
            }

            return result;
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

        private int parseInt(String word) {
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
    }
}
