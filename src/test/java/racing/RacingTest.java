package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private int             INPUT_MOVES_COUNT = 1;
    private List<String>    INPUT_CARS_NAMES = Arrays.asList("car1", "car2");

    private RacingGame mGame;

    @BeforeEach
    void setUp() {
        mGame = new RacingGame(INPUT_CARS_NAMES, INPUT_MOVES_COUNT);
    }

    @Test
    void input_generate_cars() {
        assertThat(mGame.getNumOfCars()).isEqualTo(INPUT_CARS_NAMES.size());
    }

    @Test
    void input_move_times() {
        assertThat(mGame.getNumOfMove()).isEqualTo(INPUT_MOVES_COUNT);
    }
}