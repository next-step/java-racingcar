package woowacamp.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @NullAndEmptySource
    @ParameterizedTest
    void 빈_문자열_또는_null을_입력할_경우_0을_반환해야_한다(String text) {
        int result = StringCalculator.sum(text);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_입력할_경우_해당_숫자를_반환한다() {
        String text = "1";

        int result = StringCalculator.sum(text);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void 입력을_쉼표로_구분하고_더한다() {
        String text = "1,2";

        int result = StringCalculator.sum(text);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 입력을_쉼표와_콜론으로_구분하고_더한다() {
        String text = "1,2;3";

        int result = StringCalculator.sum(text);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 입력을_커스텀_구분자로_구분하고_더한다() {
        String text = "//;\n1;2;3";

        int result = StringCalculator.sum(text);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수를_입력하면_예외가_발생한다() {
        String text = "-1,2,3";

        assertThatThrownBy(() -> StringCalculator.sum(text))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
