package racinggame.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameInputViewTest {
    @ParameterizedTest
    @ValueSource(strings = { "1", "0", "-1" })
    @DisplayName("게임에 필요한 최소 자동차 대수보다 적은 입력이 들어온 경우 예외가 발생한다")
    void testMinimumCarCount(final String input) {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream(input.getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingCarCount)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "-1" })
    @DisplayName("게임에 필요한 최소 시도회수보다 적은 입력이 들어온 경우 예외가 발생한다")
    void testMinimumRoundCount(final String input) {
        final MessageReader reader = new RacingMessageReader(
            new ByteArrayInputStream(input.getBytes())
        );
        final RacingGameInputView racingGameInputView = new RacingGameInputView(reader, new RacingMessageWriter());

        assertThatThrownBy(racingGameInputView::inputRacingRoundCount)
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}