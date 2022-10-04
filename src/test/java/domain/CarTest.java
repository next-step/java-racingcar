package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    protected static final int INIT_LOCATION = 0;

    protected static final int INCREASED_DISTANCE = 1;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상의 숫자가 주어졌을 때 현재 자동차의 위치값이 증가하는지를 확인")
    void carMovingTest(int randomNum) {

        Car testCar = new Car("testCar");

        testCar.move(randomNum);

        if (randomNum >= 4) {
            assertThat(testCar.getCurrentLocation()).isEqualTo(INCREASED_DISTANCE);
        } else {
            assertThat(testCar.getCurrentLocation()).isEqualTo(INIT_LOCATION);
        }
    }


}
