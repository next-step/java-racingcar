package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.*;
import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource("provideNotValidTotalRacingGameCount")
    @DisplayName("RacingGame racing 횟수 유효성 검사")
    void validateTotalRacingGameCount(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        this.RacingGameExceptionTest(raceInformation, carMovement, raceWinner);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarCount")
    @DisplayName("RacingGame 자동차 대수 유효성 검사")
    void validationCarNames(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        this.RacingGameExceptionTest(raceInformation, carMovement, raceWinner);
    }

    private void RacingGameExceptionTest(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        assertThatThrownBy(() -> this.createRacingGame(raceInformation, carMovement, raceWinner))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private RacingGame createRacingGame(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        return new RacingGame(raceInformation, carMovement, raceWinner);
    }

    @ParameterizedTest
    @MethodSource("provideRacingGameArguments")
    @DisplayName("RacingGame 자동차 경주 결과 테스트")
    void startRacing(RaceInformation raceInformation, RandomMovement randomMovement, RaceWinner raceWinner) {
        RacingGame racingGame = this.createRacingGame(raceInformation, randomMovement, raceWinner);
        List<RacingGameResult> racingGameResults = racingGame.executeRacing();
        assertThat(racingGameResults).hasSize(raceInformation.getTotalRacingCount());
        for (int i = 0; i < racingGameResults.size(); i++) {
            assertThat(racingGameResults.get(i).getCarRaceResultSize()).isEqualTo(raceInformation.getCarNames().length);
        }
    }

    private static Stream<Arguments> provideNotValidCarCount() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{}), createCarMovement(), createRaceWinner()),
                Arguments.of(createRaceInformation(1, null), createCarMovement(), createRaceWinner())
        );
    }

    private static Stream<Arguments> provideNotValidTotalRacingGameCount() {
        return Stream.of(
                Arguments.of(createRaceInformation(0, new String[]{"a","b"}), createCarMovement(), createRaceWinner()),
                Arguments.of(createRaceInformation(-1, new String[]{"a","b"}), createCarMovement(), createRaceWinner())
        );
    }

    private static Stream<Arguments> provideRacingGameArguments() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{"a","b"}), createCarMovement(), createRaceWinner()),
                Arguments.of(createRaceInformation(3, new String[]{"a","b"}), createCarMovement(), createRaceWinner()),
                Arguments.of(createRaceInformation(5, new String[]{"a","b"}), createCarMovement(), createRaceWinner())
        );
    }

    private static CarMovement createCarMovement() {
        return new RandomMovement(new Random());
    }

    private static RaceWinner createRaceWinner() {
        return new PositionWinner();
    }

    private static RaceInformation createRaceInformation(int totalRacingCount, String[] carNames) {
        return new RaceInformation(totalRacingCount, carNames);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidRaceInformation")
    @DisplayName("비어있는 RaceInformation Exception")
    void notValidRaceInformationTest(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        this.RacingGameExceptionTest(raceInformation, carMovement, raceWinner);
    }

    private static Stream<Arguments> provideNotValidRaceInformation() {
        return Stream.of(
                Arguments.of(null, createCarMovement(), createRaceWinner())
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarMovement")
    @DisplayName("유효하지 않은 CarMovement Exception")
    void notValidCarMovementTest(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        this.RacingGameExceptionTest(raceInformation, carMovement, raceWinner);
    }

    private static Stream<Arguments> provideNotValidCarMovement() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{"a","b"}), null, createRaceWinner())
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotValidRaceWinner")
    @DisplayName("유효하지 않은 RaceWinner Exception")
    void notValidRaceWinnerTest(RaceInformation raceInformation, CarMovement carMovement, RaceWinner raceWinner) {
        this.RacingGameExceptionTest(raceInformation, carMovement, raceWinner);
    }

    private static Stream<Arguments> provideNotValidRaceWinner() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{"a", "b"}), createCarMovement(), null)
        );
    }
}
