package racing.race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    static Stream<Arguments> invalidGames() {
        return Stream.of(
                Arguments.arguments("", 3),
                Arguments.arguments("car1,car2,car3", 0),
                Arguments.arguments("car1,car2,car3", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidGames")
    public void invalidGame(String carNamesMessage, int laps) {
        assertThatThrownBy(() -> new Game(carNamesMessage, laps))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
