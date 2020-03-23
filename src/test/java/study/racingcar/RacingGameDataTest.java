package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.domain.RacingGameData;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameDataTest {
    @DisplayName("시도 횟수가 음수여서는 안된다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:-1"}, delimiter = ':')
    void failToInit(String carNames, int time) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RacingGameData(Arrays.asList(carNames.split(",")), time);
                }).withMessage("시도 횟수는 0 이상이여야 합니다.");
    }
}
