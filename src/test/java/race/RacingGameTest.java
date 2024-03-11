package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void name() {
        RacingGame game = new RacingGame();
        String mileages = game.start(1, 1);
        assertThat(mileages).isEqualTo("-");
    }
}
