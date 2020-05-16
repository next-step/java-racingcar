package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.CarMovement;
import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.CarRaceResult;
import racing.dto.RaceInformation;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource("provideNotValidTotalRacingGameCount")
    @DisplayName("RacingGame racing 횟수 유효성 검사")
    void validateTotalRacingGameCount(RaceInformation raceInformation, CarMovement carMovement) {
        this.RacingGameExceptionTest(raceInformation, carMovement);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarCount")
    @DisplayName("RacingGame 자동차 대수 유효성 검사")
    void validationCarNames(RaceInformation raceInformation, CarMovement carMovement) {
        this.RacingGameExceptionTest(raceInformation, carMovement);
    }

    private void RacingGameExceptionTest(RaceInformation raceInformation, CarMovement carMovement) {
        assertThatThrownBy(() -> this.createRacingGame(raceInformation, carMovement))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private RacingGame createRacingGame(RaceInformation raceInformation, CarMovement carMovement) {
        return new RacingGame(raceInformation, carMovement);
    }

    @ParameterizedTest
    @MethodSource("provideRacingGameArguments")
    @DisplayName("RacingGame 자동차 경주 결과 테스트")
    void startRacing(RaceInformation raceInformation, RandomMovement randomMovement) {
        RacingGame racingGame = this.createRacingGame(raceInformation, randomMovement);
        racingGame.executeRacing();
        List<CarRaceResult> carRaceResults = racingGame.calculateCarRaceResults();
        assertThat(carRaceResults).hasSize(raceInformation.getCarNames().length);
    }

    private static Stream<Arguments> provideNotValidCarCount() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{}), createCarMovement()),
                Arguments.of(createRaceInformation(1, null), createCarMovement())
        );
    }

    private static Stream<Arguments> provideNotValidTotalRacingGameCount() {
        return Stream.of(
                Arguments.of(createRaceInformation(0, new String[]{"a","b"}), createCarMovement()),
                Arguments.of(createRaceInformation(-1, new String[]{"a","b"}), createCarMovement())
        );
    }

    private static Stream<Arguments> provideRacingGameArguments() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{"a","b"}), createCarMovement()),
                Arguments.of(createRaceInformation(3, new String[]{"a","b"}), createCarMovement()),
                Arguments.of(createRaceInformation(5, new String[]{"a","b"}), createCarMovement())
        );
    }

    private static CarMovement createCarMovement() {
        return new RandomMovement(new Random());
    }

    private static RaceInformation createRaceInformation(int totalRacingCount, String[] carNames) {
        return new RaceInformation(totalRacingCount, carNames);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidRaceInformation")
    @DisplayName("비어있는 RaceInformation Exception")
    void notValidRaceInformationTest(RaceInformation raceInformation, CarMovement carMovement) {
        this.RacingGameExceptionTest(raceInformation, carMovement);
    }

    private static Stream<Arguments> provideNotValidRaceInformation() {
        return Stream.of(
                Arguments.of(null, createCarMovement())
        );
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarMovement")
    @DisplayName("유효하지 않은 CarMovement Exception")
    void notValidCarMovementTest(RaceInformation raceInformation, CarMovement carMovement) {
        this.RacingGameExceptionTest(raceInformation, carMovement);
    }

    private static Stream<Arguments> provideNotValidCarMovement() {
        return Stream.of(
                Arguments.of(createRaceInformation(1, new String[]{"a","b"}), null)
        );
    }
}
