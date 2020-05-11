package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @ParameterizedTest
    @MethodSource("provideNotValidRacingGameArguments")
    @DisplayName("RacingGame 유효성 검사")
    void validationTest(int time, int cars) {
        assertThatThrownBy(() -> new RacingGame(time, cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRAcingGameArguments")
    @DisplayName("RacingGame StartRacing 테스트")
    void startRacing(int time, int carCount) {
        RacingGame racingGame = new RacingGame(time, carCount);
        List<Car> cars = racingGame.startRacing();
        assertThat(cars.size()).isEqualTo(carCount);
        assertThat(racingGame.racingCount()).isEqualTo(time);
    }

    private static Stream<Arguments> provideNotValidRacingGameArguments() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(0, 0)
        );
    }

    private static Stream<Arguments> provideRAcingGameArguments() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(3, 10),
                Arguments.of(5, 1)
        );
    }
}