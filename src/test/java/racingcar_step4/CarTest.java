package racingcar_step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar_step4.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("초간단 자동차 경주 테스트 - Car 클래스")
public class CarTest {
    @Test
    @DisplayName("Test1 자동차 이동")
    void carMoveOne() {
        Car car = new Car("testCar", 5);
        car.move(() -> true);
        assertThat(car.getTotalDistance()).isEqualTo(6);
    }

    @Test
    @DisplayName("Test2 자동차 정지")
    void carStop() {
        Car car = new Car("testCar", 5);
        car.move(() -> false);
        assertThat(car.getTotalDistance()).isEqualTo(5);
    }
}
