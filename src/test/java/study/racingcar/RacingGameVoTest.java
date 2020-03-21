package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameVoTest {
    @DisplayName("차 댓수와 시도 횟수가 음수여서는 안된다.")
    @ParameterizedTest
    @CsvSource(value = {"-1,1", "1,-1"})
    void failToInit(int numberOfCar, int time) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RacingGameVo(numberOfCar, time);
                }).withMessage("차 댓수와 시도 횟수는 0 이상이여야 합니다.");
    }
}
