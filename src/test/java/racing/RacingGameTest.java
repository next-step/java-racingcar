package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;
import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;
import racing.fake.FakeCar;
import racing.fake.FakeRacingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {
    private static final int MAX_POSITION = 4;

    @ParameterizedTest
    @MethodSource("provideNotValidTotalRacingGameCount")
    @DisplayName("RacingGame racing 횟수 유효성 검사")
    void validateTotalRacingGameCount(RaceInformation raceInformation) {
        this.RacingGameExceptionTest(raceInformation);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarCount")
    @DisplayName("RacingGame 자동차 대수 유효성 검사")
    void validationCarNames(RaceInformation raceInformation) {
        this.RacingGameExceptionTest(raceInformation);
    }

    private void RacingGameExceptionTest(RaceInformation raceInformation) {
        assertThatThrownBy(() -> this.createRacingGame(raceInformation))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private RacingGame createRacingGame(RaceInformation raceInformation) {
        return new RacingGame(raceInformation, new RandomMovement(new Random()));
    }

    @ParameterizedTest
    @MethodSource("provideRacingGameArguments")
    @DisplayName("RacingGame StartRacing 테스트")
    void startRacing(RaceInformation raceInformation) {
        RacingGame racingGame = this.createRacingGame(raceInformation);
        racingGame.executeRacing();
        List<RacingGameResult> racingGameResults = racingGame.calculateRacingGameResults();
        assertThat(racingGameResults).hasSize(raceInformation.getCarNames().length);
    }

    private static Stream<Arguments> provideNotValidCarCount() {
        return Stream.of(
                Arguments.of(new RaceInformation(1, new String[]{})),
                Arguments.of(new RaceInformation(1, null))
        );
    }

    private static Stream<Arguments> provideNotValidTotalRacingGameCount() {
        return Stream.of(
                Arguments.of(new RaceInformation(0, new String[]{"a","b"})),
                Arguments.of(new RaceInformation(-1, new String[]{"a","b"}))
        );
    }

    private static Stream<Arguments> provideRacingGameArguments() {
        return Stream.of(
                Arguments.of(new RaceInformation(1, new String[]{"a","b"})),
                Arguments.of(new RaceInformation(3, new String[]{"a","b"})),
                Arguments.of(new RaceInformation(5, new String[]{"a","b"}))
        );
    }

    @Test
    @DisplayName("최대 거리 계산 테스트")
    void calculateMaxPositionTest() {
        RacingGame fakeRacingGame = this.createFakeRacingGame(this.provideFakeCars());
        assertThat(fakeRacingGame.calculateMaxPosition()).isEqualTo(MAX_POSITION);
    }

    private RacingGame createFakeRacingGame(List<Car> fakeCars) {
        return new FakeRacingGame(fakeCars);
    }

    private static List<Car> provideFakeCars() {
        return Arrays.asList(
                new FakeCar("test1", MAX_POSITION),
                new FakeCar("test2", MAX_POSITION - 1),
                new FakeCar("test3", MAX_POSITION - 2),
                new FakeCar("test4", MAX_POSITION),
                new FakeCar("test5", MAX_POSITION - 1)
        );
    }
}
