package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.controller.RacingGameController;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    @DisplayName("진행 할 라운드가 없으면 hasNextRound()는 false를 반환한다")
    @Test
    void finishedGameRoundTest() {
        RacingGameController racingGameController = RacingGameController.newInstance(new String[]{"TEST1"}, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isFalse();
    }

    @DisplayName("진행 할 라운드가 존재하면 hasNextRound()는 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void progressGameRoundTest(int gameRound) {
        RacingGameController racingGameController = RacingGameController.newInstance(new String[]{"TEST1"}, gameRound);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isTrue();
    }

    @DisplayName("RacingpPostion에서 관리되는 자동차는 입력한 자동차의 개수와 동일하다")
    @ParameterizedTest
    @MethodSource("provideSourceForRacingCarsSize")
    void racingCarsSizeTest(String[] carNames) {
        RacingGameController racingGameController = RacingGameController.newInstance(carNames, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.getRacingCars().getAll()).hasSize(carNames.length);
    }

    private static Stream<Arguments> provideSourceForRacingCarsSize() {
        return Stream.of(
                Arguments.of((Object) new String[]{"TEST1", "TEST2"}),
                Arguments.of((Object) new String[]{"TEST1", "TEST2", "TEST2"}),
                Arguments.of((Object) new String[]{"TEST1", "TEST2", "TEST3", "TEST4"})
        );
    }

    @DisplayName("GameRound가 종료되었을 때 우승자는 1명 이상이다")
    @MethodSource("provideSourceForRacingCarsSize")
    @ParameterizedTest
    void finishedGameWinnerTest(String[] carNames) {
        RacingGameController racingGameController = RacingGameController.newInstance(carNames, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.getRacingCars().getWinners().size()).isGreaterThanOrEqualTo(1);
    }
}
