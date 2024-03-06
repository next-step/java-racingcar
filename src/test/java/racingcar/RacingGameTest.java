package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void drive() throws Exception {
        RacingGame racingGame = new RacingGame(() -> true, 3);
        racingGame.drive(5);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(5, 5, 5);
    }

    @Test
    void notDrive() throws Exception {
        RacingGame racingGame = new RacingGame(() -> false, 3);
        racingGame.drive(5);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }
}
