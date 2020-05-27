package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CarTest {

    // private static final int TEST_CAR_INIT_LOCATION = 0;
    private static final int TEST_CAR_MOVE_STEP = 1;


    // init
    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"carName:0", "anyTest:6", "carTest:9"}, delimiter = ':')
    public void testClassInitialize(String carName, int location) {

        Car car = new Car(carName, location, new CarMoveStrategy() {
            @Override
            public int getMoveCount() {
                return TEST_CAR_MOVE_STEP;
            }
        });

        // test

        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.getLocation()).isEqualTo(location);

    }

    // move test
    @DisplayName("Move Test")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 99, 100})
    public void testMoveStep(int input) {

        // ready
        Car car = new Car("testCarName", input, new CarMoveStrategy() {
            @Override
            public int getMoveCount() {
                return TEST_CAR_MOVE_STEP;
            }
        });

        // set
        car.move();

        // test
        assertThat(car.getLocation()).isEqualTo(input + TEST_CAR_MOVE_STEP);

    }
}
