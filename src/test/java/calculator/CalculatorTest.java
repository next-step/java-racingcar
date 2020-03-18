package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void calculateOnePartTest() {
        //given
        InputView inputView = new InputView("1 + 2 / 3");
        InputArray inputArray = new InputArray(inputView);
        Calculator calculator = new Calculator(inputArray);

        //when
        double result = calculator.calculateOnePart(0);

        //then
        assertThat(result).isEqualTo(3);
    }
}
