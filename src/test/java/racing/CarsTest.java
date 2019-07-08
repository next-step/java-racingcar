package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.strategy.DrivingMoveStrategy;
import racing.domain.strategy.DrivingStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    static public String INPUT_CAR_NAME = "car";
    static public String INPUT_CAR_NAME_COMPARED = "compared_car";

    private List<String> names;
    private Cars mCars;
    private DrivingStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        names = Arrays.asList(INPUT_CAR_NAME, INPUT_CAR_NAME_COMPARED);
        moveStrategy = new DrivingMoveStrategy();
        mCars = new Cars(names);
    }

    @Test
    void input_generate_cars() {
        assertThat(mCars.size()).isEqualTo(names.size());
    }

    @Test
    void go_car() {
        Car target = mCars.getCar(0);
        Car anotherTarget = mCars.getCar(1);

        mCars.go(moveStrategy);

        assertThat(mCars.findCarsInPosition(1)).contains(target, anotherTarget);
    }

    @Test
    void find_max_position() {
        Car target = mCars.getCar(0);
        target.goOrNot(moveStrategy);

        assertThat(mCars.findFirstPosition()).isEqualTo(1);
    }

    @Test
    void find_cars_in_position() {
        Car target = mCars.getCar(0);
        Car anotherTarget = mCars.getCar(1);

        assertThat(mCars.findCarsInPosition(0)).contains(target, anotherTarget);
    }
}
