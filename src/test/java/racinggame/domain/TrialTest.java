package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.InputBlankException;

class TrialTest {

    @DisplayName("생성자 테스트")
    @Test
    void 생성자() {
        // given
        final String input = "5";
        final Trial trial = new Trial(input);

        // then
        assertThat(trial.getValue()).isEqualTo(5);
    }

    @ValueSource(strings = {"1 0", " 10", " 1 0 ", "10 ", "1   0  "})
    @ParameterizedTest
    void getTrial_불필요한_공백이_들어왔을_때_제거(final String inputTrial) {
        // when
        final int trial = new Trial(inputTrial).getValue();

        // then
        assertThat(trial).isEqualTo(10);
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_실패() {
        // given
        final String input = "a";

        // then
        assertThrows(NumberFormatException.class, () -> new Trial(input));
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_성공() {
        // given
        final String input = "5";

        // then
        assertDoesNotThrow(() -> new Trial(input));
    }

    @ValueSource(strings = {" ", "", "\n", "\t"})
    @ParameterizedTest
    void 시도횟수에_공백이_들어오면_예외발생(String input) {

        // then
        assertThrows(InputBlankException.class, () -> new Trial(input));
    }
}
