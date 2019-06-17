package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.strategy.DrivingMoveStrategy;
import racing.strategy.DrivingStopStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private int INPUT_CARS_COUNT = 1;
    private int INPUT_MOVES_COUNT = 1;

    private RacingGame mGame;
    private Car mCar;

    @BeforeEach
    void setUp() {
        mGame = new RacingGame(INPUT_CARS_COUNT, INPUT_MOVES_COUNT);
        mCar = new Car();
    }

    @Test
    void input_generate_cars() {
        assertThat(mGame.getNumOfCars()).isEqualTo(INPUT_CARS_COUNT);
    }

    @Test
    void input_move_times() {
        assertThat(mGame.getNumOfMove()).isEqualTo(INPUT_MOVES_COUNT);
    }

    @Test
    void go() {
        mCar.goOrNot(new DrivingMoveStrategy());

        assertThat(mCar.position).isEqualTo(1);
    }

    @Test
    void stop() {
        mCar.goOrNot(new DrivingStopStrategy());

        assertThat(mCar.position).isEqualTo(0);
    }

    @Test
    void print_position() {
        mCar.go();

        assertThat(mCar.getMovesRoad()).isEqualTo("-");
    }
}
