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

    @DisplayName("빈 값의 경우 0 반환")
    @Test
    void split1() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result1 = calculator.split("");
        int result2 = calculator.split(null);

        //then
        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @DisplayName("1의 경우 1반환")
    @Test
    void split2() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.split("1");

        //then
        assertThat(result).isEqualTo(1);
    }
}
