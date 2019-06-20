package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.strategy.DrivingMoveStrategy;
import racing.strategy.DrivingStopStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private String INPUT_CAR_NAME = "car";

    private Car mCar;

    @BeforeEach
    void setUp() {
        mCar = new Car(INPUT_CAR_NAME);
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
        mCar.goOrNot(new DrivingMoveStrategy());

        assertThat(mCar.getMovesRoad()).isEqualTo("-");
    }

    @Test
    void name() {
        assertThat(mCar.getName()).isEqualTo(INPUT_CAR_NAME);
    }
}
