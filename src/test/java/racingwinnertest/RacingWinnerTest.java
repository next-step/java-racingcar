package racingwinnertest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingwinner.RacingGame;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnerTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(new String[]{"pobi", "crong", "honux"}, 5);
    }

    @DisplayName("Test for 'moveOrNot'")
    @Test
    void moveOrNotTest() {
        assertThat(racingGame.moveOrNot(0)).isEqualTo(false);
        assertThat(racingGame.moveOrNot(3)).isEqualTo(false);
        assertThat(racingGame.moveOrNot(4)).isEqualTo(true);
        assertThat(racingGame.moveOrNot(9)).isEqualTo(true);
    }

    @DisplayName("Test for 'findMax'")
    @Test
    void findMaxTest() {
        assertThat(racingGame.findMax(3, 3)).isEqualTo(3);
        assertThat(racingGame.findMax(3, 4)).isEqualTo(4);
    }
}
