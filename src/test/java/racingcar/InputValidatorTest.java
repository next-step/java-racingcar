package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {

    @Test
    void carNameIsBlankGiven_ReturnTrue() {
        assertThat(InputValidator.isInputWrong("")).isTrue();
    }

    @Test
    void carNameIsOver5Given_ReturnTrue() {
        assertThat(InputValidator.isInputWrong("abcdfeg,abc")).isTrue();
    }

    @Test
    void carNameIsUnder6Given_ReturnFalse() {
        assertThat(InputValidator.isInputWrong("abcde,abc")).isFalse();
    }
}
