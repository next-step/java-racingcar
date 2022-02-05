package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void parseOperationTest() {
        String[] strings1 = {"13", "+", "5"};
        String[] strings2 = {"10", "-", "5"};
        int start = 0;
        Calculator.parseOperation(strings1, start);
        assertThat(strings1[2]).isEqualTo("18");
        Calculator.parseOperation(strings2, start);
        assertThat(strings2[2]).isEqualTo("5");
    }
}