package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CalculatorTest {

    @Test
    public void 연산_테스트() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 2));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "*", "/"));

        Calculator calculator = new Calculator();
        calculator.calculate(nums, operators);

        Assertions.assertThat(calculator.calculate(nums, operators)).isEqualTo(10);
    }

    @Test
    public void 연산_예외_케이스(){
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 2));
        List<String> operators = new ArrayList<>(Arrays.asList("+", "*", ")"));

        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> { calculator.calculate(nums, operators); }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 값_세팅_케이스() {
        Play play = new Play();
        Assertions.assertThat(10).isEqualTo(play.setting("2 + 3 * 4 / 2"));
    }
}

