package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("빈 배열의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_빈_배열() {
        int[] nums = {};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 값만 있는 배열의 덧셈 계산은 해당 값이다")
    @Test
    void 덧셈_계산_하나() {
        int[] nums = {7};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(7);
    }
    @DisplayName("둘 이상의 덧셈 계산이 올바르게 수행되어야 한다")
    @Test
    void 덧셈_계산_둘_이상() {
        int[] nums = {1, 4, 10};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(15);
    }
}