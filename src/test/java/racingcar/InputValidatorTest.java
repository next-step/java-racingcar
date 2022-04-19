package racingcar;

import code.PromptMessage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void carNameIsBlankGiven_ThrowException() {
        assertThatThrownBy(() -> InputValidator.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PromptMessage.INPUT_HAVE_TO_BE_NOT_BLANK.getMessage());
    }

    @Test
    void carNameIsOver5Given_ThrowException() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(new String[]{"abcdef"}))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PromptMessage.CAR_NAME_IS_EQUAL_LOWER_THAN_5.getMessage());
    }
}
