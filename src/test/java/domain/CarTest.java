package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    protected static final int INIT_LOCATION = 0;

    protected static final int INCREASED_DISTANCE = 1;

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차가 이동하는 경우 (4이상의 값만 주어짐)")
    void carMovingForwardTest(int randomNum) {

        Car testCar = Car.of("testCar");

        testCar.move(randomNum);

        assertThat(testCar.getCurrentLocation()).isEqualTo(INCREASED_DISTANCE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차가 이동하지 않는 경우 (4미만의 값만 주어짐)")
    void carMovingStopTest(int randomNum) {

        Car testCar = Car.of("testCar");

        testCar.move(randomNum);

        assertThat(testCar.getCurrentLocation()).isEqualTo(INIT_LOCATION);

    }

}
