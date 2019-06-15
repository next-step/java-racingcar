package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private RacingGame mGame;

    @BeforeEach
    void setUp() {
        mGame = new RacingGame();
    }

    @Test
    void input_generate_cars() {
        mGame.setNumOfCars(3);

        assertThat(mGame.getNumOfCars()).isEqualTo(3);
    }

    @Test
    void input_move_times() {
        mGame.setNumOfMove(2);

        assertThat(mGame.getNumOfMove()).isEqualTo(2);
    }
}
