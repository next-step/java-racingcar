package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차가 생성되면 position 0인 상태로 생성이 되는지")
    @Test
    void createCarTest() {
        Car car = Car.createCar();
        assertThat(car.getPosition).isEqualTo(0);
    }
}
