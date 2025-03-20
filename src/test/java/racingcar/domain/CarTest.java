package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤 숫자가 9일 때 한칸 이동한다.")
    void move_GO() {
        Car car = createCar(9);
        car.move();
        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("랜덤 숫자가 1일 때 STOP 이므로 이동하지 않는다.")
    void move_STOP() {
        Car car = createCar(1);
        car.move();
        assertThat(0).isEqualTo(car.getPosition());
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
