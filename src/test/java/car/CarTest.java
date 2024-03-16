package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private static final String TEST_CAR_NAME = "test";
    private static final String ERROR_TEST_CAR_NAME = "testtest";
    private static final int ERROR_TEST_CAR_DISTANCE = -1;
    private static final int TEST_CAR_DISTANCE = 0;

    @Test
    @DisplayName("자동차가 전진 기록 남기고 있는지 확인하는 테스트")
    public void testIsMovingCar() {
        Car car = new Car(TEST_CAR_NAME, TEST_CAR_DISTANCE);
        car.move(true);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 정상적으로 할당되는지 테스트")
    public void testCarName() {
        Car car = new Car(TEST_CAR_NAME, TEST_CAR_DISTANCE);
        assertThat(car.getName()).isEqualTo(TEST_CAR_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 5자이상이면 생성 안되는 테스트")
    public void testErrorCarName() {
        assertThatThrownBy(() -> new Car(ERROR_TEST_CAR_NAME, TEST_CAR_DISTANCE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 초기화 거리가 음수이면 생성 안되는 테스트")
    public void testErrorCarDistance() {
        assertThatThrownBy(() -> new Car(ERROR_TEST_CAR_NAME, ERROR_TEST_CAR_DISTANCE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
