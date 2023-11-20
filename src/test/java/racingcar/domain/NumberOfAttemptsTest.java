package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.domain.NumberOfAttempts.NONE_LEFT_NUMBER_OF_ATTEMPTS_EXCEPTION;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberOfAttemptsTest {

    @ParameterizedTest
    @DisplayName("시도를 한번하면 숫자가 하나 줄어듭니다.")
    @CsvSource(value = {"3, 2", "10, 9", "1, 0"})
    void calculate_left_race_attempts(long given, long expected) {
        // given
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(given);

        // when
        NumberOfAttempts result = numberOfAttempts.attempt();

        // then
        assertThat(result).isEqualTo(new NumberOfAttempts(expected));
    }

    @ParameterizedTest
    @DisplayName("남은 경주 횟수가 음수면 예외를 던진다.")
    @ValueSource(longs = {0, -1, -16})
    void create_number_of_attempts_exception(long given) {
        // when // then
        assertThatThrownBy(() -> new NumberOfAttempts(given).attempt())
                .isExactlyInstanceOf(IllegalStateException.class)
                .hasMessage(NONE_LEFT_NUMBER_OF_ATTEMPTS_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("남은 경주 횟수가 존재하는지 확인한다.")
    @CsvSource(value = {"0, false", "1, true"})
    void check_left_number_of_attempts_exists(long given, boolean expected) {
        // given
        NumberOfAttempts numberOfAttempts = new NumberOfAttempts(given);

        // when
        boolean result = numberOfAttempts.isLeft();

        // then
        assertThat(result).isEqualTo(expected);
    }
}
