package carracing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    @Test
    void doRacing() {
        RacingGame racingGame = new RacingGame(Arrays.asList("A", "B", "C"));
        assertThat(racingGame.doRacing(() -> true)).containsExactly(
                new Car("A", 1),
                new Car("B", 1),
                new Car("C", 1)
        );
    }

    @Test
    void findWinner() {
        RacingGame racingGame = new RacingGame(Arrays.asList("A", "B", "C"));
        racingGame.doRacing(() -> true);
        assertThat(racingGame.findWinner()).contains(
                new Car("A", 1),
                new Car("B", 1),
                new Car("C", 1)
        );
    }

}
