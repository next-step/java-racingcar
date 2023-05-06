package racing.race;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.ui.DisplayView;
import racing.vehicle.Car;
import racing.vehicle.CarName;
import racing.vehicle.CarNames;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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
        assertThatThrownBy(() -> Game.builder()
                .setCarNames(carNamesMessage)
                .setLaps(laps)
                .build()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void builder() {
        // given
        String carNames = "car1,car2,car3";
        int laps = 5;

        // when
        Game game = Game.builder()
                .setCarNames(carNames)
                .setLaps(laps)
                .build();

        // then
        CarNames expectedCarNames = new CarNames(carNames);
        assertThat(game.getParticipants().getCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList())
        ).isEqualTo(expectedCarNames.getNames());
        assertThat(game.getLaps()).isEqualTo(laps);
    }
}
