package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("이전 연산의 결과값과 다음에 연산할 연산자의 인덱스를 주면 다음 연산의 결과값이 반환된다.")
    @Test
    void calculateOnePartTest() {
        //given
        InputView inputView = new InputView("1 + 2 / 3");
        InputArray inputArray = new InputArray(inputView);
        Calculator calculator = new Calculator(inputArray);

        //when
        double result = calculator.calculateOnePart(1, 0);

        //then
        assertThat(result).isEqualTo(3);
    }
}
