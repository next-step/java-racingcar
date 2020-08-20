package carracing;

import carracing.domain.car.Car;
import carracing.domain.car.strategy.CarPowerCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    Car car;

    @Test
    @DisplayName("Car 객체 생성 후 position 설정")
    void Car_객체생성() {
        car = new Car("car1");
        car.setPosition(new CarPowerCondition());
        assertThat(car.getPosition());

    }

    @Test
    @DisplayName("자동차 이름 5자 이상 Exception 발생")
    void 자동자이름_테스트() {
        assertThatThrownBy(() -> car = new Car("niceCar"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
