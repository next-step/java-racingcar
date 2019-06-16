package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private RacingGame mGame;
    private Car mCar;

    @BeforeEach
    void setUp() {
        mGame = new RacingGame();
        mCar = new Car();
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
        boolean result = mCar.isAvailToGo(randValue);

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int randValue) {
        boolean result = mCar.isAvailToGo(randValue);

        assertThat(result).isFalse();
    }

    @Test
    void print_position() {
        mCar.go();

        assertThat(mCar.getMovesRoad()).isEqualTo("-");
    }
}
