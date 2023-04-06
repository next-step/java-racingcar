package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CalculatorTest {

    @DisplayName("분리한 각 숫자의 합을 반환")
    @Test
    void sum() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.sum(Arrays.asList(1, 2, 3));

        //then
        assertThat(result).isEqualTo(6);
    }
}
