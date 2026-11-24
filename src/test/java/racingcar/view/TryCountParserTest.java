package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TryCountParserTest {
    @ParameterizedTest
    @CsvSource(value = {"'1':1", "'5':5", "' 3 ':3"}, delimiter = ':')
    @DisplayName("입력한 숫자만큼 회차를 진행할 수 있는 시도 횟수를 반환한다")
    void parse(String input, int expectedRounds) {
        TryCount tryCount = TryCountParser.parse(input);

        assertThat(countPlayableRounds(tryCount)).isEqualTo(expectedRounds);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    @DisplayName("입력이 null이거나 비어 있으면 IllegalArgumentException")
    void throwsExceptionWhenInputIsEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> TryCountParser.parse(input))
                .withMessage("try count is required");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "3a"})
    @DisplayName("숫자가 아니면 IllegalArgumentException")
    void throwsExceptionWhenNotNumber(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> TryCountParser.parse(input))
                .withMessage("try count must be a number [" + input + "]");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("양수가 아니면 IllegalArgumentException")
    void throwsExceptionWhenNotPositive(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> TryCountParser.parse(input))
                .withMessage("try count must be positive [" + input + "]");
    }

    private static int countPlayableRounds(TryCount tryCount) {
        int rounds = 0;
        while (tryCount.hasRemaining()) {
            tryCount.decrease();
            rounds++;
        }
        return rounds;
    }
}
