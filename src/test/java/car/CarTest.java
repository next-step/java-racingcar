package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final String TEST_CAR_NAME = "test";
    private static final int TEST_CAR_DISTANCE = 0;

    @Test
    @DisplayName("자동차가 전진 기록 남기고 있는지 확인하는 테스트")
    public void testIsMovingCar() {
        Car car = new Car(TEST_CAR_NAME, TEST_CAR_DISTANCE);
        car.move(() -> true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

}
