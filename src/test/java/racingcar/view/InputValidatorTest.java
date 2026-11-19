package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {";", ":", "abc"})
    void 숫자가_아닌_시도_횟수를_입력하면_예외를_던진다(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "pobi,,crong", "pobi, crong"})
    void 이름_형식이_잘못되면_예외를_던진다(String input) {
        assertThatThrownBy(() -> InputValidator.validateNames(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 쉼표로_구분된_올바른_이름_형식은_통과한다() {
        assertThatCode(() -> InputValidator.validateNames("pobi,crong,honux"))
                .doesNotThrowAnyException();
    }
}