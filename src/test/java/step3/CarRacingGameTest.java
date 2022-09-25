package step3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingGameTest {
    @Test
    public void carRacingGameTest() {
        CarRacingGame carRacingGame = new CarRacingGame(5, 3);
        carRacingGame.doGame();
        assertThat(carRacingGame.getCarEntrySize()).isEqualTo(5);
    }
}