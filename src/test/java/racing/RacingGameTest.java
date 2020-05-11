package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.RacingCreateDto;
import racing.dto.RacingResultDto;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource("provideNotValidTotalRacingGameCount")
    @DisplayName("RacingGame racing 횟수 유효성 검사")
    void validateTotalRacingGameCount(RacingCreateDto racingCreateDto) {
        assertThatThrownBy(() -> new RacingGame(racingCreateDto, new RandomMovement(new Random())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideNotValidCarCount")
    @DisplayName("RacingGame 자동차 유효성 검사")
    void validationTest(RacingCreateDto racingCreateDto) {
        assertThatThrownBy(() -> new RacingGame(racingCreateDto, new RandomMovement(new Random())))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRacingGameArguments")
    @DisplayName("RacingGame StartRacing 테스트")
    void startRacing(RacingCreateDto racingCreateDto) {
        RacingGame racingGame = new RacingGame(racingCreateDto, new RandomMovement(new Random()));
        RacingResultDto racingResultDto = racingGame.racingResult();
        assertThat(racingResultDto.result()).hasSize(racingCreateDto.carCount());
    }

    private static Stream<Arguments> provideNotValidCarCount() {
        return Stream.of(
                Arguments.of(new RacingCreateDto(1, 0)),
                Arguments.of(new RacingCreateDto(1, -1))
        );
    }

    private static Stream<Arguments> provideNotValidTotalRacingGameCount() {
        return Stream.of(
                Arguments.of(new RacingCreateDto(0, 1)),
                Arguments.of(new RacingCreateDto(-1, 1))
        );
    }
    private static Stream<Arguments> provideRacingGameArguments() {
        return Stream.of(
                Arguments.of(new RacingCreateDto(1, 1)),
                Arguments.of(new RacingCreateDto(3, 10)),
                Arguments.of(new RacingCreateDto(5, 1))
        );
    }
}