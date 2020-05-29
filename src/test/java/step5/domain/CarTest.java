package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.*;

class CarTest {

    private static final int TEST_CAR_MOVE_STEP = 1;

    // init
    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"carName:0", "anyTest:6", "carTest:9"}, delimiter = ':')
    public void testClassInitialize(String carName, int location) {

        Car car = new Car(carName, location, () -> TEST_CAR_MOVE_STEP);

        // test
        assertThat(car.getCarName()).isEqualTo(carName);
        assertThat(car.getLocation()).isEqualTo(location);

    }


    // init
    @DisplayName("init Class")
    @ParameterizedTest
    @CsvSource(value = {"anyTest:-1", "carTest:-229"}, delimiter = ':')
    public void testClassInitializeWithInputError(String carName, int location) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car(carName, location, () -> 0);
        });
    }

    // init
    @DisplayName("init Class with null")
    @ParameterizedTest
    @CsvSource(value = {":0"}, delimiter = ':')
    public void testClassInitializeWithNull(String carName, int location) {
        assertThatNullPointerException().isThrownBy(() -> {
            Car car = new Car(carName, location, () -> 0);
        });
    }


    // move test
    @DisplayName("Move Test")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 99, 100})
    public void testMoveStep(int input) {

        // ready
        Car car = new Car("testCarName", input, () -> TEST_CAR_MOVE_STEP);

        // set
        car.move();

        // test
        assertThat(car.getLocation()).isEqualTo(input + TEST_CAR_MOVE_STEP);

    }
}
