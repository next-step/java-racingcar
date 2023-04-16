package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTest {
    Positive positive;

    @BeforeEach
    void setUp() {
        this.positive = new Positive();
    }

    @Test
    @DisplayName("양수 문자열 배열을 받아 양수 숫자 배열로 반환한다.")
    void 양수_문자열_배열을_양수_배열로_반환() {
        final String[] numbers = new String[]{"1", "2", "3"};
        assertThat(positive.toPositiveInts(numbers))
                .containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("음수 문자열 배열을 받을 경우 RuntimeException을 반환한다.")
    void 음수가_있는_문자열_배열_숫자_배열로() {
        final String[] numbers = new String[]{"1", "-2", "3"};
        assertThatThrownBy(() -> positive.toPositiveInts(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("양수 문자열 배열을 받아 합을 구한다")
    void 양수_문자열_배열의_합() {
        final int[] numbers = new int[]{1, 2, 3};
        assertThat(positive.sumPositiveNumbers(numbers))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("음수 문자열 배열의 합을 구할 경우 RuntimeException을 반환한다.")
    void 음수가_있는_문자열_배열의_합() {
        final int[] numbers = new int[]{1, -2, 3};
        assertThatThrownBy(() -> positive.sumPositiveNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
