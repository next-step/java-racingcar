package woowacamp.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import woowacamp.calculator.Calculator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("숫자 목록을 입력받아 합을 반환한다.")
    void test_01() {
        /* given */
        List<Integer> numbers = List.of(1, 2, 3, 4);

        /* when */
        int result = Calculator.sum(numbers);

        /* then */
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("숫자가 하나인 경우 그 수를 반환한다.")
    void test_02() {
        /* given */
        List<Integer> numbers = List.of(0);

        /* when */
        int result = Calculator.sum(numbers);

        /* then */
        assertThat(result).isEqualTo(0);
    }
}
