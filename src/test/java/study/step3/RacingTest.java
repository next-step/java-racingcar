package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("레이싱게임이 아직 끝나지 않음")
    @Test
    void isFinished() {
        Racing racing = Racing.of(Cars.of(5), 3);
        assertThat(racing.isFinished()).isFalse();
    }

    @DisplayName("레이싱게임 정상 종료")
    @ParameterizedTest
    @CsvSource(value = {"3:5", "3:6", "5:3"}, delimiter = ':')
    void race(int carNumber, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNumber), attemptNumber);
        for (int i = 0; i < attemptNumber; i++) {
            racing.race();
        }
        assertThat(racing.isFinished()).isEqualTo(true);
    }
}
