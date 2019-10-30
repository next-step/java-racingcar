package step1.racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PreparationTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4})
    void list_size_same_as_input(int players) {
        assertThat(Preparation.initRacingGame(players).size()).isEqualTo(players);
    }
}
