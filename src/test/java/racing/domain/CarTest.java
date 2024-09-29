package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차가 생성되면 position 0인 상태로 생성이 되는지")
    @Test
    void createCarTest() {
        Car car = Car.createCar();
        assertThat(car.getCurrentPosition()).isZero();
    }

    @DisplayName("자동차가 생성된 랜덤 난수가 4 이상인 경우 한 칸 전진하는지")
    @Test
    void carMoveTest() {
        Car car = Car.createCar();
        car.move();
        assertThat(car.getCurrentPosition()).isOne();
    }
}
