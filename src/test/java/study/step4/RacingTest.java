package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("레이싱게임이 아직 끝나지 않음")
    @ParameterizedTest
    @CsvSource(value = "자동차1호,자동차2호:3", delimiter = ':')
    void isFinished(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(RacingConstant.COMMA)), attemptNumber, new RandomMoveBehavior());
        assertThat(racing.isFinished()).isFalse();
    }

    @DisplayName("레이싱게임 정상 종료")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호:2", "자동차1호,자동차2호,자동차3호:3"}, delimiter = ':')
    void race(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(RacingConstant.COMMA)), attemptNumber, new RandomMoveBehavior());
        for (int i = 0; i < attemptNumber; i++) {
            racing.race();
        }
        assertThat(racing.isFinished()).isTrue();
    }
}
