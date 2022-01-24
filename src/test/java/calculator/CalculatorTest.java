package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void parseOperationTest() {
        String[] stringArray1 = {"13", "+", "5"};
        String[] stringArray2 = {"10", "-", "5"};
        int start = 0;
        Calculator.parseOperation(stringArray1, start);
        assertThat(stringArray1[2]).isEqualTo("18");
        Calculator.parseOperation(stringArray2, start);
        assertThat(stringArray2[2]).isEqualTo("5");
    }
}