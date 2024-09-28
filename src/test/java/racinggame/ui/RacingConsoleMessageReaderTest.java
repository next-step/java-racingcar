package racinggame.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingConsoleMessageReaderTest {
    @ParameterizedTest
    @ValueSource(strings = { "이상한문자열", "숫자가아니다", "예외발생문자열" })
    @DisplayName("숫자가 아닌 문자열이 들어올 경우 예외가 발생한다.")
    void testOnlyNumber(final String input) {
        final RacingConsoleMessageReader reader = new RacingConsoleMessageReader(
            new ByteArrayInputStream(input.getBytes())
        );
        assertThatThrownBy(reader::read)
            .isExactlyInstanceOf(InputMismatchException.class);
    }

    @ParameterizedTest
    @CsvSource(value = { "5,5", "7,7", "9,9" })
    @DisplayName("숫자로 변환가능한 문자열이 넘어왔을 경우 해당 값을 반환한다.")
    void testBindInteger(final String input, final int except) {
        final RacingConsoleMessageReader reader = new RacingConsoleMessageReader(
            new ByteArrayInputStream(input.getBytes())
        );

        assertThat(reader.read()).isEqualTo(except);
    }
}