package woowacamp.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 숫자_목록을_입력받아_합을_반환한다() {
        List<Integer> numbers = List.of(1, 2, 3, 4);

        int result = Calculator.sum(numbers);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void 숫자가_하나이면_경우_그_수를_반환한다() {
        List<Integer> numbers = List.of(0);

        int result = Calculator.sum(numbers);

        assertThat(result).isEqualTo(0);
    }
}
