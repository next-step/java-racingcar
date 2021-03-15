package study.step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingTest {

    @DisplayName("Exception 테스트, 시도횟수 입력 오류")
    @ParameterizedTest
    @CsvSource(value = {"yunho,pobi:0", "yunho,pobi:-1"}, delimiter = ':')
    void carNameLengthOver(String carNames, int attemptNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());
        }).withMessage("시도횟수는 최소 1회 이상이어야 합니다.");
    }

    @DisplayName("레이싱게임 진행, 레이싱 진행횟수 상태값 확인")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호:2", "자동차1호,자동차2호,자동차3호:3"}, delimiter = ':')
    void getAttemptCount(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());

        for (int i = 0; i < attemptNumber; i++) {
            racing.race();
        }

        assertThat(racing.getAttemptCount()).isEqualTo(attemptNumber);
    }

    @DisplayName("레이싱게임이 아직 끝나지 않음")
    @ParameterizedTest
    @CsvSource(value = "자동차1호,자동차2호:3", delimiter = ':')
    void isFinished(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());
        assertThat(racing.isFinished()).isFalse();
    }

    @DisplayName("레이싱게임 정상 종료")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호:2", "자동차1호,자동차2호,자동차3호:3"}, delimiter = ':')
    void race(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());

        for (int i = 0; i < attemptNumber; i++) {
            racing.race();
        }

        assertThat(racing.isFinished()).isTrue();
    }
}
