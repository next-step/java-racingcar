package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameManagerTest {

    @DisplayName("진행 할 라운드가 없으면 hasNextRound()는 false를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void finishedGameRoundTest(int carCount) {
        RacingGameManager racingGameManager = RacingGameManager.start(carCount, 1);
        racingGameManager.nextRound();

        assertThat(racingGameManager.hasNextRound()).isFalse();
    }

    @DisplayName("진행 할 라운드가 존재하면 hasNextRound()는 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void progressGameRoundTest(int gameRound) {
        RacingGameManager racingGameManager = RacingGameManager.start(1, gameRound);
        racingGameManager.nextRound();

        assertThat(racingGameManager.hasNextRound()).isTrue();
    }

    @DisplayName("Position List의 size는 생성된 자동차의 개수와 동일하다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void carPositionSizeTest(int carCount) {
        RacingGameManager racingGameManager = RacingGameManager.start(carCount, 1);
        racingGameManager.nextRound();

        assertThat(racingGameManager.getCarPosition()).hasSize(carCount);
    }
}
