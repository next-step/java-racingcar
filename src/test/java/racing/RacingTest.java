package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.strategy.DrivingMoveStrategy;
import racing.strategy.DrivingStopStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private int             INPUT_MOVES_COUNT = 1;
    private List<String>    INPUT_CARS_NAMES = Arrays.asList("car1", "car2");
    private String          INPUT_CAR_NAME = "car";

    private RacingGame mGame;
    private Car mCar;

    @BeforeEach
    void setUp() {
        mGame = new RacingGame(INPUT_CARS_NAMES, INPUT_MOVES_COUNT);
        mCar = new Car(INPUT_CAR_NAME);
    }

    @Test
    void input_generate_cars() {
        assertThat(mGame.getNumOfCars()).isEqualTo(INPUT_CARS_NAMES.size());
    }

    @Test
    void input_move_times() {
        assertThat(mGame.getNumOfMove()).isEqualTo(INPUT_MOVES_COUNT);
    }

    @Test
    void go() {
        mCar.goOrNot(new DrivingMoveStrategy());

        assertThat(mCar.getPosition()).isEqualTo(1);
    }

    @Test
    void stop() {
        mCar.goOrNot(new DrivingStopStrategy());

        assertThat(mCar.getPosition()).isEqualTo(0);
    }

    @Test
    void print_position() {
        mCar.go();

        assertThat(mCar.getMovesRoad()).isEqualTo("-");
    }

    @Test
    void name() {
        assertThat(mCar.getName()).isEqualTo(INPUT_CAR_NAME);
    }
}