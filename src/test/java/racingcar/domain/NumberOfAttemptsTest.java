package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
