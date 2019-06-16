package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void go(int randValue) {
        boolean isGo = mGame.checkGoOrNot(randValue);

        assertThat(isGo).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int randValue) {
        boolean isGo = mGame.checkGoOrNot(randValue);

        assertThat(isGo).isFalse();
    }
}
