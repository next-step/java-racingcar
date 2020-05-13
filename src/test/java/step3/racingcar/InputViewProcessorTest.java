package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class InputViewProcessorTest {

    @DisplayName("User Input이 1 미만일 경우 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(ints = {-15, 0})
    public void throwExceptionWhenUserInputIsUnder1(int input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    InputViewProcessor.validateUserInput(input);
                });
    }

}
