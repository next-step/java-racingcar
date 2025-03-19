package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.Car.GO;
import static step3.domain.Car.STOP;

class CarTest {

    private final Car car = new Car();

    @Test
    @DisplayName("GO 상태일 때 updatePosition 메서드를 호출하면 position은 -가 추가된다.")
    void updatePosition_GO() {
        car.updatePosition(GO);
        assertThat(GO).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("STOP 상태일 때 updatePosition 메서드를 호출하면 position은 변하지 않는다.")
    void updatePosition_STOP() {
        car.updatePosition(STOP);
        assertThat("").isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 9일 때 GO 상태로 이동")
    void move_GO() {
        Car car = createCar(9);
        car.move();
        assertThat(GO).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 1일 때 STOP 상태로 이동")
    void move_STOP() {
        Car car = createCar(1);
        car.move();
        assertThat("").isEqualTo(car.getPosition());
    }

    private Car createCar(int randomNumber) {
        return new Car() {
            @Override
            protected int generateRandomNumber() {
                return randomNumber;
            }
        };
    }
}
