package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitUtilsTest {

    @Test
    @DisplayName("입력을 기본 구분자(`,`, `:`, `;`)로 분리한다.")
    void test_01() {
        /* given */
        String text = "1,2:3;4";

        /* when */
        List<Integer> numbers = SplitUtils.convertToNumbers(text);

        /* then */
        assertThat(numbers).containsExactly(1, 2, 3, 4);
    }

    @ValueSource(strings = {"//충규\n1충규2충규3충규4", "//충\n1충2충3충4", "//규\n1규2규3규4"})
    @ParameterizedTest
    @DisplayName("입력을 커스텀 구분자로 분리한다.")
    void test_01_1(String input) {
        /* given */

        /* when */
        List<Integer> numbers = SplitUtils.convertToNumbers(input);

        /* then */
        assertThat(numbers).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("입력에 음수가 포함돼있으면 IllegalArgumentException을 던진다.")
    void test_02() {
        /* given */
        String input = "1:-1:2";

        /* when & then */
        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력에 실수가 포함돼있으면 IllegalArgumentException을 던진다.")
    void test_03() {
        /* given */
        String input = "1:1.2:2";

        /* when & then */
        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력에 문자가 포함돼있으면 IllegalArgumentException을 던진다.")
    void test_04() {
        /* given */
        String input = "1:a:2";

        /* when & then */
        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력에 공백이 있으면 0으로 처리한다.")
    void test_05() {
        /* given */
        String input = "       ";

        /* when */
        List<Integer> numbers = SplitUtils.convertToNumbers(input);

        /* then */
        assertThat(numbers).containsExactly(0);
    }
}
