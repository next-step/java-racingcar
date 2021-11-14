package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("4이상의 수로 operate하면 차가 전진하고, 4미만의 수로 operate하면 차가 멈춘다.")
    @Test
    void operate() {
        Car car = new Car();
        car.move(CarOperation.from(4));
        assertThat( car.getPosition(0)).isEqualTo(1);

        car.move(CarOperation.from(4));
        assertThat( car.getPosition(1)).isEqualTo(2);


        car.move(CarOperation.from(1));
        assertThat( car.getPosition(1)).isEqualTo(2);

    }

}