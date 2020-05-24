package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.Car;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("TestCar");
    }

    @Test
    @DisplayName("정상적인 자동차 이동 테스트")
    void carMoveTestFunction() {
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("정상적인 자동차 비 이동 테스트")
    void carStopTestFunction() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    @DisplayName("자동차 이름 설정 테스트")
    void carNameTestFunction() {
        String carName = car.getName();
        assertThat(carName).isEqualTo("TestCar");
    }
}
