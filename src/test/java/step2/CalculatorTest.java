package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {

    @Test
    public void 계산기테스트() {

        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 2));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "*", "/"));

        Calculator calculator = new Calculator();
        calculator.calculate(nums, operators);

        Assertions.assertThat(calculator.calculate(nums, operators)).isEqualTo(10);
    }

    @Test
    public void 계산예외케이스() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 2));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "*", ")"));

        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> { calculator.calculate(nums, operators); }).isInstanceOf(IllegalArgumentException.class);
    }
}

