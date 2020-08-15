package step5.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void create_RaceGame_Initialize() {
        String[] carsName = new String[]{"Jamie", "Goal"};
        RacingGame raceGame = new RacingGame(Arrays.asList(carsName));
        assertThat(raceGame).isNotNull();

    }
}