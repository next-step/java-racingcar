package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @DisplayName("랜덤 발생 숫자가 4미만인 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void car_random_under_4(int randomNum) {
        Car car = new RacingCar(() -> {
            return 4 <= randomNum;
        });
        car.racing();
        assertThat(car.printResult().length()).isZero();
    }

    @DisplayName("랜덤 발생 숫자가 4이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void car_random_upper_4(int randomNum) {
        Car car = new RacingCar(() -> {
            return 4 <= randomNum;
        });
        car.racing();
        assertThat(car.printResult()).isEqualTo("- ");
    }
}