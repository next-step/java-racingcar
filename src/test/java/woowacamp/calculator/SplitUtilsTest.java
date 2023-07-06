package woowacamp.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitUtilsTest {

    @Test
    void 입력을_기본_구분자로_분리한다() {
        String text = "1,2:3;4";

        List<Integer> numbers = SplitUtils.convertToNumbers(text);

        assertThat(numbers).containsExactly(1, 2, 3, 4);
    }

    @ValueSource(strings = {"//충규\n1충규2충규3충규4", "//충\n1충2충3충4", "//규\n1규2규3규4"})
    @ParameterizedTest
    void 입력을_커스틈_구분자로_분리한다(String input) {
        List<Integer> numbers = SplitUtils.convertToNumbers(input);

        assertThat(numbers).containsExactly(1, 2, 3, 4);
    }

    @Test
    void 입력에_음수가_포함돼있으면_예외가_발생한다() {
        String input = "1:-1:2";

        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력에_실수가_포함돼있으면_예외가_발생한다() {
        String input = "1:1.2:2";

        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력에_문지가_포함돼있으면_예외가_발생한다() {
        String input = "1:a:2";

        assertThatThrownBy(() -> SplitUtils.convertToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 입력에_공백이_있으면_0으로_처리한다(String input) {
        List<Integer> numbers = SplitUtils.convertToNumbers(input);

        assertThat(numbers).containsExactly(0);
    }
}
