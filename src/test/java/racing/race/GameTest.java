package racing.race;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,2"})
    public void validGame(int participantsCount, int laps) {
        Game game = new Game(participantsCount, laps);
        assertThat(game.participantsStream()).hasSize(participantsCount);
        assertThat(game.lapsStream()).hasSize(laps);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,2", "-1, 0", "0, -2"})
    public void invalidGame(int participantsCount, int laps) {
        assertThatThrownBy(() -> new Game(participantsCount, laps))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
