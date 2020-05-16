package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.controller.RacingGameController;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    @DisplayName("진행 할 라운드가 없으면 hasNextRound()는 false를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void finishedGameRoundTest(int carCount) {
        RacingGameController racingGameController = RacingGameController.start(carCount, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isFalse();
    }

    @DisplayName("진행 할 라운드가 존재하면 hasNextRound()는 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void progressGameRoundTest(int gameRound) {
        RacingGameController racingGameController = RacingGameController.start(1, gameRound);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isTrue();
    }

    @DisplayName("Position List의 size는 생성된 자동차의 개수와 동일하다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void carPositionSizeTest(int carCount) {
        RacingGameController racingGameController = RacingGameController.start(carCount, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.getCarPosition()).hasSize(carCount);
    }
}
