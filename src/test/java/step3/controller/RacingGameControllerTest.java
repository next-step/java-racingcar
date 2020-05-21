package step3.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import step3.domain.GameRandomRule;
import step3.domain.GameRule;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameControllerTest {

    @DisplayName("진행 할 라운드가 없으면 hasNextRound()는 false를 반환한다")
    @Test
    void finishedGameRoundTest() {
        RacingGameController racingGameController =
                RacingGameController.newInstance(new GameRandomRule(), new String[]{"TEST1"}, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isFalse();
    }

    @DisplayName("진행 할 라운드가 존재하면 hasNextRound()는 true 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"2", "3", "4"})
    void progressGameRoundTest(int gameRound) {
        RacingGameController racingGameController =
                RacingGameController.newInstance(new GameRandomRule(), new String[]{"TEST1"}, gameRound);
        racingGameController.nextRound();

        assertThat(racingGameController.hasNextRound()).isTrue();
    }

    @DisplayName("RacingpPostion에서 관리되는 자동차는 입력한 자동차의 개수와 동일하다")
    @ParameterizedTest
    @MethodSource("provideSourceForRacingCarsSize")
    void racingCarsSizeTest(String[] carNames) {
        RacingGameController racingGameController =
                RacingGameController.newInstance(new GameRandomRule(), carNames, 1);
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
        RacingGameController racingGameController =
                RacingGameController.newInstance(new GameRandomRule(), carNames, 1);
        racingGameController.nextRound();

        assertThat(racingGameController.getRacingCars().getWinners().size()).isGreaterThanOrEqualTo(1);
    }

    @DisplayName("isMovable()이 true를 반환하면 자동차 position이 1씩 증가한다")
    @MethodSource("provideSourceForRacingCarsSize")
    @ParameterizedTest
    void immovableGameTest(String[] carNames) {
        RacingGameController racingGameController =
                RacingGameController.newInstance(new ForwardGameRule(), carNames, 10);

        IntStream.range(0, 10).forEach(i -> {
            racingGameController.nextRound();
            racingGameController.getRacingCars().getAll().forEach(racingCar -> {
                assertThat(racingCar.getPosition()).isEqualTo(i + 1);
            });
        });
    }

    @DisplayName("isMovable()이 false를 반환하면 자동차 position이 1씩 증가한다")
    @MethodSource("provideSourceForRacingCarsSize")
    @ParameterizedTest
    void movableGameTest(String[] carNames) {
        RacingGameController racingGameController =
                RacingGameController.newInstance(new StopGameRule(), carNames, 10);

        IntStream.range(0, 10).forEach(i -> {
            racingGameController.nextRound();
            racingGameController.getRacingCars().getAll().forEach(racingCar -> {
                assertThat(racingCar.getPosition()).isEqualTo(0);
            });
        });
    }

    public static class ForwardGameRule implements GameRule {

        @Override
        public boolean isMovable() {
            return true;
        }
    }

    public static class StopGameRule implements GameRule {

        @Override
        public boolean isMovable() {
            return false;
        }
    }
}
