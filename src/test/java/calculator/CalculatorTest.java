package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void calculateTest() {
        String[] expression1 = {"13", "+", "5"};
        String[] expression2 = {"10", "-", "5"};
        String[] expression3 = {"10", "-", "5", "+", "2"};
        Calculator.calculate(expression1);
        assertThat(expression1[2]).isEqualTo("18");
        Calculator.calculate(expression2);
        assertThat(expression2[2]).isEqualTo("5");
        Calculator.calculate(expression3);
        assertThat(expression3[4]).isEqualTo("7");
    }
}